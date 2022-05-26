package ru.itis.semesterwork2.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import ru.itis.semesterwork2.dto.request.SignUpForm;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "my_user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 30)
    private String firstName;

    @Column(length = 30)
    private String lastName;

    @Column(length = 30)
    private String patronymic;

    private String email;
    private String password;

    private String dateOfBirth;

    private String photoName;

    public enum Role{
        TEACHER,STUDENT
    }


    @Enumerated(value = EnumType.STRING)
    private Role role;

    public static User from(SignUpForm form){
        return User.builder()
                .firstName(form.getFirstName())
                .lastName(form.getLastName())
                .patronymic(form.getPatronymic())
                .email(form.getEmail())
                .role(Role.valueOf(form.getRole()))
                .build();
    }


    public static List<User> from(List<SignUpForm> forms){
        return forms.stream().map(User::from).collect(Collectors.toList());
    }

}
