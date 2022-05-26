package ru.itis.semesterwork2.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ChangePasswordForm {
    @NotBlank
    private String oldPassword;
    @NotBlank
    @Length(min = 8, message = "Пароль должен содержать не менее {min} символов")
    private String newPassword;
    @NotBlank
    private String repeatPassword;
}
