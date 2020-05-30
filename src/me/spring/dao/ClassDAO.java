package me.spring.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import me.spring.entity.Class;

public interface ClassDAO extends JpaRepository<Class, Integer> {
	Page<Class> findByProjectId(int projectId, Pageable pageable);
}