package ru.itis.semesterwork2.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SignInForm {
    @Email
    private String email;

    @NotBlank
    private String password;

    private boolean rememberMe;
}
