package com.ssafy.sandbox.controller;

import com.ssafy.sandbox.dto.TodoListResponseDto;
import com.ssafy.sandbox.dto.TodoRequestDto;
import com.ssafy.sandbox.service.TodoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/todos")
@RequiredArgsConstructor
public class TodoController {
    private final TodoService todoService;

    // Create
    @PostMapping
    public ResponseEntity<Long> createTodo(@RequestBody TodoRequestDto requestDto) {
        long id = todoService.createTodo(requestDto);
        log.info("logInfo: create success");
        return new ResponseEntity<>(id, HttpStatus.CREATED);
    }

    // Read
    @GetMapping
    public ResponseEntity<TodoListResponseDto> getAllTodos() {
        return new ResponseEntity<>(todoService.getAllTodos(), HttpStatus.OK);
    }

    // Update
    @PatchMapping("/{todoId}")
    public ResponseEntity<Void> updateTodoStatus(@PathVariable("todoId") Long todoId) {
        todoService.updateTodoStatus(todoId);
        log.info("logInfo: update success");
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    // Delete
    @DeleteMapping("/{todoId}")
    public ResponseEntity<Void> deleteTodoById(@PathVariable("todoId") Long todoId) {
        todoService.deleteTodoById(todoId);
        log.info("logInfo: delete success");
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
