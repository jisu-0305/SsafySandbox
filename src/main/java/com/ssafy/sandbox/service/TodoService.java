package com.ssafy.sandbox.service;

import java.util.List;

import com.ssafy.sandbox.dto.TodoResponseDto;
import com.ssafy.sandbox.dto.TodoRequestDto;

public interface TodoService {
    // Create
    TodoResponseDto createTodo(TodoRequestDto requestDto);

    // Read
    List<TodoResponseDto> getAllTodos();

    // Update
    TodoResponseDto updateTodoStatus(Long id);

    // Delete
    void deleteTodoById(Long id);
}

