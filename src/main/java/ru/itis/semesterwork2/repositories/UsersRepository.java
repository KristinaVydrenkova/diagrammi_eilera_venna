package ru.itis.semesterwork2.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.itis.semesterwork2.models.User;

import java.util.Optional;

@Repository
public interface UsersRepository extends JpaRepository<User,Long>{
    Optional<User> findByEmail(String email);
}
