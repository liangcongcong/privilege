package me.spring.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import me.spring.entity.EndType;

public interface EndTypeDAO extends JpaRepository<EndType, Integer> {
}
