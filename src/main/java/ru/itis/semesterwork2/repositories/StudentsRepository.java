package ru.itis.semesterwork2.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.itis.semesterwork2.models.Student;
import ru.itis.semesterwork2.models.Teacher;

import java.util.Set;

public interface StudentsRepository extends JpaRepository<Student,Long> {
    Student getByUserId(Long userId);
    Set<Student> findAllByTeacher(Teacher teacher);

    @Query("SELECT s FROM Student s WHERE s.teacher = (select t from Teacher t where t.user.id = ?1)")
    Set<Student> findAllByTeacherUser(Long userId);
}
