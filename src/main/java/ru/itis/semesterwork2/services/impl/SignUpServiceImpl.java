package ru.itis.semesterwork2.services.impl;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.itis.semesterwork2.dto.request.SignInForm;
import ru.itis.semesterwork2.dto.request.SignUpForm;
import ru.itis.semesterwork2.dto.response.UserResponse;
import ru.itis.semesterwork2.exceptions.*;
import ru.itis.semesterwork2.models.*;
import ru.itis.semesterwork2.repositories.*;
import ru.itis.semesterwork2.services.SignUpService;
import ru.itis.semesterwork2.utils.EmailConfirmer;
import ru.itis.semesterwork2.utils.mappers.UserMapper;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class SignUpServiceImpl implements SignUpService {
    private static final Logger log = LoggerFactory.getLogger(StudentsServiceImpl.class);

    private final EmailConfirmer emailConfirmer;

    private final String OCCUPIED_EMAIL = "Пользователь с таким email уже существует";
    private final String PASSWORDS_DONT_MATCH = "Пароли не совпадают";
    private final String NOT_EMAIL = "Такого email не существует";

    private final UsersRepository usersRepository;
    private final StudentsRepository studentsRepository;
    private final TeachersRepository teachersRepository;
    private final TasksRepository tasksRepository;
    private final PointsRepository pointsRepository;

    private final PasswordEncoder passwordEncoder;

    private final UserMapper userMapper;
    @Override
    public UserResponse signUp(SignUpForm form) {
        log.trace("Method signUp started");

        if(!emailConfirmer.confirm(form.getEmail())){
            log.debug("Email doesn't exist");
            throw new InvalidEmailException(NOT_EMAIL);
        }
        User user = userMapper.toEntity(form);
        user.setPassword(passwordEncoder.encode(form.getPassword()));
        log.info("Got user "+user.getEmail()+" to sign up");
        if(usersRepository.findByEmail(user.getEmail()).isPresent()){
            log.debug(user.getEmail()+ " is occupied");
            throw new OccupiedEmailException(OCCUPIED_EMAIL);
        }
        if(!form.getPassword().equals(form.getRepeatPassword())){
            log.debug("Passwords don't match");
            throw new BadPasswordException(PASSWORDS_DONT_MATCH);
        }
        usersRepository.save(user);
        log.debug("saved user " + user.getEmail());
        if(user.getRole().equals(User.Role.STUDENT)){
            Student student = new Student();
            student.setUser(user);
            studentsRepository.save(student);
            log.debug("saved student " + user.getEmail());
        }
        if(user.getRole().equals(User.Role.TEACHER)) {
            Teacher teacher = new Teacher();
            teacher.setUser(user);
            teachersRepository.save(teacher);
            log.debug("saved teacher " + user.getEmail());
        }
        log.trace("Method signUp finished");
        return userMapper.toResponse(user);
    }

    @Override
    public UserResponse signIn(SignInForm form) {
        log.trace("Method signIn started");
        User user = usersRepository.findByEmail(form.getEmail()).get();
        log.debug("Got user"+user.getEmail()+"to sign in");
        if(user!=null&&user.getPassword().equals(passwordEncoder.encode(form.getPassword()))){
            log.debug("User "+user.getEmail() + " is correct");
            log.trace("Method signIn finished with no mistakes");
            return userMapper.toResponse(user);
        }else{
            log.debug("User "+user.getEmail() + " is wrong");
            throw new NoSuchEmailException("Неправильный логин или пароль");
        }
    }

    @Override
    public void signOut(User user) {
        log.trace("Method signOut started");
        if(user.getRole().equals(User.Role.TEACHER)){
            Optional<Teacher> teacherOptional = teachersRepository.findByUserId(user.getId());
            if(!teacherOptional.isPresent()){
                log.debug("Teacher not found " + user.getEmail());
                throw new TeacherException("Пользователь не найден");
            }
            Teacher teacher = teacherOptional.get();
            log.debug("Got teacher " + user.getEmail());
            log.debug("Got teacher from user " + user.getEmail());
            for(Task task:tasksRepository.findAllByTeacher(teacher)) {
                for(Student student:studentsRepository.findAllByTeacher(teacher)){
                    student.getTasks().remove(task);
                    student.setTeacher(null);
                    studentsRepository.save(student);
                    log.debug("Database updated with saving student");
                }
                tasksRepository.delete(task);
                log.debug("Database updated with deleting task");
            }
            teachersRepository.delete(teacher);
            log.debug("Database updated with deleting teacher");
        }else{
            Student student = studentsRepository.getByUserId(user.getId());
            log.debug("Got student from user " + user.getEmail());
            for (Point point: pointsRepository.findAllByStudent(student)){
                pointsRepository.delete(point);
                log.debug("Database updated with deleting point");
            }
            student.setTasks(null);
            studentsRepository.delete(student);
            log.debug("Database updated with deleting student");
        }
        usersRepository.delete(user);
        log.debug("Database updated with deleting user");
    }
}
