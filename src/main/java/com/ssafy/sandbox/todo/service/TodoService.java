package com.ssafy.sandbox.todo.service;


import com.ssafy.sandbox.todo.dto.TodoListResponseDto;
import com.ssafy.sandbox.todo.dto.TodoRequestDto;

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

