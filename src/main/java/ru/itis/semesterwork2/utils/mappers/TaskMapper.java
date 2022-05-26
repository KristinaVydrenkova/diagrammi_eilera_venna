package ru.itis.semesterwork2.utils.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.itis.semesterwork2.dto.request.AddTaskRequest;
import ru.itis.semesterwork2.dto.response.TaskForTeacherResponse;
import ru.itis.semesterwork2.models.Task;

import java.util.Set;

@Mapper(componentModel = "spring")
public interface TaskMapper {
    TaskForTeacherResponse toResponse(Task task);
    Set<TaskForTeacherResponse> toResponseSet(Set<Task> tasks);

    @Mapping(target = "deadline", ignore = true)
    Task toEntity(AddTaskRequest addTaskRequest);
}
