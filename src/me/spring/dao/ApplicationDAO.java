package me.spring.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import me.spring.entity.Application;

public interface ApplicationDAO extends JpaRepository<Application, Integer> {
}
