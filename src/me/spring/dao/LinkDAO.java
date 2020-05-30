package me.spring.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import me.spring.entity.Link;

public interface LinkDAO extends JpaRepository<Link, Integer> {
}
