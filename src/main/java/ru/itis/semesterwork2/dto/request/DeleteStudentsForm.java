package ru.itis.semesterwork2.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DeleteStudentsForm {
    @NotNull(message = "Выберите хотя бы 1 ученика")
    private List<String> deleteStudents;
}
