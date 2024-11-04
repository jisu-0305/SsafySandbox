package com.ssafy.sandbox.todo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.ssafy.sandbox.todo.model.Todo;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Long> {
}

