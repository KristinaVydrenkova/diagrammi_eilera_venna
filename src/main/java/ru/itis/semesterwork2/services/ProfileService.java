package ru.itis.semesterwork2.services;

import ru.itis.semesterwork2.dto.request.ChangePasswordForm;
import ru.itis.semesterwork2.dto.request.EditProfileFormRequest;
import ru.itis.semesterwork2.dto.response.EditProfileFormResponse;
import ru.itis.semesterwork2.dto.response.UserResponse;
import ru.itis.semesterwork2.models.User;

public interface ProfileService {

    UserResponse getProfilePage(User user);

    EditProfileFormResponse getEditProfileForm(User user);

    UserResponse editProfile(EditProfileFormRequest form, User user);
    String changePassword(ChangePasswordForm form, User user);
}
