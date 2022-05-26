package ru.itis.semesterwork2.services.impl;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.itis.semesterwork2.dto.request.ChangePasswordForm;
import ru.itis.semesterwork2.dto.request.EditProfileFormRequest;
import ru.itis.semesterwork2.dto.response.EditProfileFormResponse;
import ru.itis.semesterwork2.dto.response.UserResponse;
import ru.itis.semesterwork2.exceptions.BadPasswordException;
import ru.itis.semesterwork2.models.User;
import ru.itis.semesterwork2.repositories.UsersRepository;
import ru.itis.semesterwork2.services.ProfileService;
import ru.itis.semesterwork2.utils.mappers.UserMapper;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ProfileServiceImpl implements ProfileService {
    private static final Logger log = LoggerFactory.getLogger(ProfileServiceImpl.class);

    @Value("${default-photo-name}")
    private String defaultPhotoName;

    @Value("${file-storage-path}")
    private String fileStoragePath;

    private final String PASSWORDS_DONT_MATCH = "Пароли не совпадают";
    private final String WRONG_OLD_PASSWORD = "Старый пароль введён неверно";
    private final String PASSWORD_CHANGED = "Пароль успешно изменён";

    private final PasswordEncoder passwordEncoder;

    private final UserMapper userMapper;

    private final UsersRepository usersRepository;

    @Override
    public UserResponse getProfilePage(User user) {
        log.trace("Method getProfilePage started");
        if (user.getPhotoName() == null) {
            user.setPhotoName(defaultPhotoName);
        }
        log.trace("Method getProfilePage finished without mistakes");
        return userMapper.toResponse(user);
    }

    @Override
    public EditProfileFormResponse getEditProfileForm(User user) {
        return userMapper.toEditProfileFormResponse(user);
    }

    @Override
    public UserResponse editProfile(EditProfileFormRequest form, User user) {
        log.trace("Method editProfile started");
        if (form.getEmail() != null) {
            log.debug("Updated email " + form.getEmail());
            user.setEmail(form.getEmail());
        }
        if (form.getDateOfBirth() != null) {
            if(!form.getDateOfBirth().equals("")) {
                log.debug("Updated date of birth " + form.getDateOfBirth());
                user.setDateOfBirth(formatDate(form.getDateOfBirth()));
            }
        }
        try {
            if (form.getPhoto().getInputStream().available() != 0) {
                log.debug("Updated photo");
                String uuidPhotoName = UUID.randomUUID().toString() + ".jpg";
                Files.copy(form.getPhoto().getInputStream(), Path.of(fileStoragePath + "\\" + uuidPhotoName));
                user.setPhotoName(uuidPhotoName);
            }
        } catch (IOException e) {
            log.error("Problems with file");
        }
        log.trace("Method editProfile finished without mistakes");
        return userMapper.toResponse(usersRepository.save(user));
    }
    @Override
    public String changePassword(ChangePasswordForm form, User user) {
        log.trace("Method changePassword started");
        if (form.getNewPassword().equals(form.getRepeatPassword())) {
            if (passwordEncoder.matches(form.getOldPassword(), user.getPassword())) {
                user.setPassword(passwordEncoder.encode(form.getNewPassword()));
                usersRepository.save(user);
                log.debug("Updated database with updating user");
                log.trace("Method changePassword finished without mistakes");
                return PASSWORD_CHANGED;
            } else {
                log.debug("Wrong password");
                throw new BadPasswordException(WRONG_OLD_PASSWORD);
            }
        } else {
            log.debug("Passwords don't match");
            throw new BadPasswordException(PASSWORDS_DONT_MATCH);
        }

    }

    private String formatDate(String date){
        String[] numbers = date.split("-");
        return numbers[2]+"."+numbers[1]+"."+numbers[0];
    }
}
