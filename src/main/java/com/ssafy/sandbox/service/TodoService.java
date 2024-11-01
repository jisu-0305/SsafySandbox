package com.ssafy.sandbox.service;


import com.ssafy.sandbox.dto.TodoListResponseDto;
import com.ssafy.sandbox.dto.TodoRequestDto;

public interface TodoService {
    // Create
    long createTodo(TodoRequestDto requestDto);

    // Read
    TodoListResponseDto getAllTodos();

    // Update
    void updateTodoStatus(Long id);

    // Delete
    void deleteTodoById(Long id);
}

