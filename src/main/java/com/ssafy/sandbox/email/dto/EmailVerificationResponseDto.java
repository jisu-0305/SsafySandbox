package com.ssafy.sandbox.email.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class EmailVerificationResponseDto {
    private boolean isSuccess;

    public static EmailVerificationResponseDto success() {
        return new EmailVerificationResponseDto(true);
    }

    public static EmailVerificationResponseDto failure() {
        return new EmailVerificationResponseDto(false);
    }
}

