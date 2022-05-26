package ru.itis.semesterwork2.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.itis.semesterwork2.models.Point;
import ru.itis.semesterwork2.models.Student;
import ru.itis.semesterwork2.models.Test;

import java.util.Optional;
import java.util.Set;

public interface PointsRepository extends JpaRepository<Point,Integer> {
    @Query("SELECT p FROM Point p WHERE p.student.id = ?1 and p.test.id = ?2")
    Optional<Point> findByStudentAndTest(Long studentId, Long testId);

    Set<Point> findAllByStudent(Student student);

    @Query("SELECT p FROM Point p WHERE p.student = (select s from Student s where s.user.id = ?1)")
    Set<Point> findAllByStudentUser(Long userId);
}
