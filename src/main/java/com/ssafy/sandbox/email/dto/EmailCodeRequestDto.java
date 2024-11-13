package com.ssafy.sandbox.email.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class EmailCodeRequestDto {
    private String email;
    private String authentication;
}
