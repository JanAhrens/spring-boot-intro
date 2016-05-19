package io.github.janahrens.example02.db.repository;

import io.github.janahrens.example02.db.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
