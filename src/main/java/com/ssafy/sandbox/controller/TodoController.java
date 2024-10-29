package com.ssafy.sandbox.controller;

import com.ssafy.sandbox.dto.TodoListResponseDto;
import com.ssafy.sandbox.dto.TodoRequestDto;
import com.ssafy.sandbox.dto.TodoResponseDto;
import com.ssafy.sandbox.service.TodoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "https://ssafysandbox.vercel.app")
@Slf4j
@RestController
@RequestMapping("/todos")
@RequiredArgsConstructor
public class TodoController {
    private final TodoService todoService;

    // Create
    @PostMapping
    public ResponseEntity<TodoResponseDto> createTodo(@RequestBody TodoRequestDto requestDto) {
        TodoResponseDto responseDto = todoService.createTodo(requestDto);
        log.info("log: Create {} todo", responseDto);
        return new ResponseEntity<>(responseDto, HttpStatus.CREATED);
    }

    // Read
    @GetMapping
    public ResponseEntity<TodoListResponseDto> getAllTodos() {
        TodoListResponseDto todos = new TodoListResponseDto(todoService.getAllTodos());
        log.info("log: Get {} todos", todos.getTodos().size());
        return new ResponseEntity<>(todos, HttpStatus.OK);
    }

    // Update
    @PatchMapping("/{todoId}")
    public ResponseEntity<TodoResponseDto> updateTodoStatus(@PathVariable Long todoId, @RequestBody boolean completed) {
        TodoResponseDto responseDto = todoService.updateTodoStatus(todoId, completed);
        log.info("log: update todo id: {} , status: {}", todoId, responseDto.isCompleted());
        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }

    // Delete
    @DeleteMapping("/{todoId}")
    public ResponseEntity<String> deleteTodoById(@PathVariable Long todoId) {
        todoService.deleteTodoById(todoId);
        log.info("log: delete todo id: {}", todoId);
        return new ResponseEntity<>("삭제가 완료되었습니다.", HttpStatus.OK);
    }
}
