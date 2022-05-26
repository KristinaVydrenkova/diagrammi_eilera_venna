package ru.itis.semesterwork2.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TaskForTeacherResponse {
    private Long id;
    private String task;
    private String deadline;
}
