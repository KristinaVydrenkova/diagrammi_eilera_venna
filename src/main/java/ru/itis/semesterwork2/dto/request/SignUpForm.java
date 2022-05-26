package ru.itis.semesterwork2.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;
import ru.itis.semesterwork2.models.User;

import javax.validation.constraints.*;
import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SignUpForm {
    @NotBlank()
    @Length(min = 2,max = 15)
    private String firstName;

    @NotNull()
    @Length(min = 1,max = 20)
    private String lastName;

    @Length(min = 3,max = 20)
    private String patronymic;

    @Email(message = "Email не подходит")
    private String email;

    @NotBlank
    @Length(min = 8, max = 25)
    private String password;

    @NotBlank()
    private String repeatPassword;

    @NotBlank
    private String role;

    public static SignUpForm from(User user){
        return SignUpForm.builder()
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .patronymic(user.getPatronymic())
                .email(user.getEmail())
                .password(user.getPassword())
                .role(user.getRole().name())
                .build();
    }


    public static List<SignUpForm> from(List<User> users){
        return users.stream().map(SignUpForm::from).collect(Collectors.toList());
    }


}
