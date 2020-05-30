package me.spring.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import me.spring.entity.Class;
import me.spring.entity.ClassField;

public interface ClassFieldDAO extends JpaRepository<ClassField, Integer> {
	Page<ClassField> findByClassId(int classId, Pageable pageable);
}