package com.ssafy.sandbox.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class TodoListResponseDto {
    private List<TodoResponseDto> todos;  // 기존 TodoResponseDto 리스트를 감싸는 필드
}
