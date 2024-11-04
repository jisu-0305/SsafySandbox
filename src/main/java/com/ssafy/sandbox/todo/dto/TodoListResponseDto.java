package com.ssafy.sandbox.todo.dto;

import com.ssafy.sandbox.todo.model.Todo;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class TodoListResponseDto {
    private List<Todo> todos;  // 기존 TodoResponseDto 리스트를 감싸는 필드
}
