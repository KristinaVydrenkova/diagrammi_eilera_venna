package ru.itis.semesterwork2.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.semesterwork2.models.Teacher;

import java.util.Optional;

public interface TeachersRepository extends JpaRepository<Teacher,Long> {
    Optional<Teacher> findByUserId(Long userId);
}
