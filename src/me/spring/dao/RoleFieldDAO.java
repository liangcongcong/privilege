package me.spring.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import me.spring.entity.RoleField;

public interface RoleFieldDAO extends JpaRepository<RoleField, Integer> {
	Page<RoleField> findByProjectId(int projectId, Pageable pageable);
}