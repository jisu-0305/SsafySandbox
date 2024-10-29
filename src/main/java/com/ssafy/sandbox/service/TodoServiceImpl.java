package com.ssafy.sandbox.service;

import com.ssafy.sandbox.dto.TodoRequestDto;
import com.ssafy.sandbox.dto.TodoResponseDto;
import com.ssafy.sandbox.entity.Todo;
import com.ssafy.sandbox.repository.TodoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TodoServiceImpl implements TodoService {
    private final TodoRepository todoRepository;

    // Create
    @Transactional
    @Override
    public TodoResponseDto createTodo(TodoRequestDto requestDto) {
        Todo todo = new Todo();
        todo.setContent(requestDto.getContent());
        todo.setCompleted(false);
        Todo savedTodo = todoRepository.save(todo);
        return new TodoResponseDto(savedTodo.getId(), savedTodo.getContent(), savedTodo.isCompleted());
    }

    // Read
    @Transactional(readOnly = true)
    @Override
    public List<TodoResponseDto> getAllTodos() {
        return todoRepository.findAll().stream()
                .map(todo -> new TodoResponseDto(todo.getId(), todo.getContent(), todo.isCompleted()))
                .collect(Collectors.toList());
    }

    // Update
    @Transactional
    @Override
    public TodoResponseDto updateTodoStatus(Long id) {
        Todo todo = todoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Todo not found"));
        todo.setCompleted(!todo.isCompleted());  // 상태 반전: true -> false, false -> true
        todoRepository.save(todo);
        return new TodoResponseDto(todo.getId(), todo.getContent(), todo.isCompleted());
    }

    // Delete
    @Transactional
    @Override
    public void deleteTodoById(Long id) {
        if (!todoRepository.existsById(id)) {
            throw new IllegalArgumentException("Todo not found");
        }
        todoRepository.deleteById(id);
    }
}

