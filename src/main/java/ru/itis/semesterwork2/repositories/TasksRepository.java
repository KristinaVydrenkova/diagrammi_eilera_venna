package ru.itis.semesterwork2.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.semesterwork2.models.Task;
import ru.itis.semesterwork2.models.Teacher;

import java.util.Optional;
import java.util.Set;

public interface TasksRepository extends JpaRepository<Task,Long> {
    Set<Task> findAllByTeacher(Teacher teacher);

    Optional<Task> findById(Long id);
}
