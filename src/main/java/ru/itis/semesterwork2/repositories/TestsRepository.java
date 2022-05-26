package ru.itis.semesterwork2.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.semesterwork2.models.Test;

public interface TestsRepository extends JpaRepository<Test,Long> {
    Test findByName(String name);
}
