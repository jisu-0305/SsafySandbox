package com.ssafy.sandbox.email.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class EmailSendResponseDto {
    private boolean isOk;

    public static EmailSendResponseDto success() {
        return new EmailSendResponseDto(true);
    }

    public static EmailSendResponseDto failure() {
        return new EmailSendResponseDto(false);
    }
}

