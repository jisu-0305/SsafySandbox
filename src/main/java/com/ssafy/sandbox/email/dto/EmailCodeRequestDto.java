package com.ssafy.sandbox.email.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class EmailCodeRequestDto {
    private String email;
    private String code;
}
