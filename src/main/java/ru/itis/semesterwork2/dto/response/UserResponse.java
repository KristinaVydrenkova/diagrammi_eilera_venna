package ru.itis.semesterwork2.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserResponse {
    private String firstName;
    private String lastName;
    private String patronymic;
    private String email;
    private String dateOfBirth;
    private String role;
    private String photoName;

}
