package ru.itis.semesterwork2.services;

import ru.itis.semesterwork2.dto.request.ChangePasswordForm;
import ru.itis.semesterwork2.dto.request.SignInForm;
import ru.itis.semesterwork2.dto.request.SignUpForm;
import ru.itis.semesterwork2.dto.response.UserResponse;
import ru.itis.semesterwork2.models.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public interface SignUpService {
    UserResponse signUp(SignUpForm form);
    UserResponse signIn(SignInForm form);
    void signOut(User user);
}
