package com.ssafy.sandbox.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.ssafy.sandbox.entity.Todo;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Long> {
}

