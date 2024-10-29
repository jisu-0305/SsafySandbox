package com.ssafy.sandbox.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class TodoResponseDto {
    private Long id;
    private String content;
    private boolean completed;
}
