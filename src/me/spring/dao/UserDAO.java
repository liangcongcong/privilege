package me.spring.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import me.spring.entity.User;

public interface UserDAO extends JpaRepository<User, Integer> {
}
