package me.spring.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import me.spring.entity.Operator;

public interface OperatorDAO extends JpaRepository<Operator, Integer> {
}
