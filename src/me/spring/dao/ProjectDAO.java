package me.spring.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import me.spring.entity.Project;

public interface ProjectDAO extends JpaRepository<Project, Integer> {
}
