package com.ssafy.sandbox.email.dto;

import lombok.Getter;

@Getter
public class EmailVerificationRequestDto {
    private String email;

    public EmailVerificationRequestDto(String email) {
        this.email = email;
    }
}
