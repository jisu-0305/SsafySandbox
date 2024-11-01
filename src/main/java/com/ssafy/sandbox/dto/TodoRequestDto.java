package com.ssafy.sandbox.dto;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class TodoRequestDto {
    private String content;
}