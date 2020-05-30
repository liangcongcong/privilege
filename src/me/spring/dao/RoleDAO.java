package me.spring.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import me.spring.entity.Role;

public interface RoleDAO extends JpaRepository<Role, Integer> {
	Page<Role> findByProjectId(int projectId, Pageable pageable);
}