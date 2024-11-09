package com.ssafy.sandbox.todo.service;

import com.ssafy.sandbox.todo.dto.TodoListResponseDto;
import com.ssafy.sandbox.todo.dto.TodoRequestDto;
import com.ssafy.sandbox.todo.model.Todo;
import com.ssafy.sandbox.todo.repository.TodoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TodoServiceImpl implements TodoService {
    private final TodoRepository todoRepository;

    @Transactional
    @Override
    public long createTodo(TodoRequestDto requestDto) {
        Todo todo = Todo.of(requestDto.getContent());
        return todoRepository.save(todo).getId();
    }

    @Transactional(readOnly = true)
    @Override
    public TodoListResponseDto getAllTodos() {
        List<Todo> todos = todoRepository.findAll();
        return new TodoListResponseDto(todos);
    }
    
    @Transactional
    @Override
    public void updateTodoStatus(Long id) {
        Todo todo = todoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Todo not found"));
        todo.toggleCompleted();
        todoRepository.save(todo);
    }

    @Transactional
    @Override
    public void deleteTodoById(Long id) {
        if (!todoRepository.existsById(id)) {
            throw new IllegalArgumentException("Todo not found");
        }

        todoRepository.deleteById(id);
    }
}

