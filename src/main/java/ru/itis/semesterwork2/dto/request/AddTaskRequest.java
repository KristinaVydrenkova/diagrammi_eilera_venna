package ru.itis.semesterwork2.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AddTaskRequest {
    @NotBlank
    private String task;

    @NotNull
    @Pattern(regexp = "20[0-9][0-9]-[0-1][0-9]-[0-3][0-9]", message = "Неверная дата")
    private String deadline;
}
