package com.ssafy.sandbox.email.service;

import com.ssafy.sandbox.email.dto.EmailCodeRequestDto;
import com.ssafy.sandbox.email.dto.EmailSendResponseDto;
import com.ssafy.sandbox.email.dto.EmailVerificationRequestDto;
import com.ssafy.sandbox.email.dto.EmailVerificationResponseDto;

public interface EmailService {
    EmailSendResponseDto sendEmailVerification(EmailVerificationRequestDto requestDto);

    EmailVerificationResponseDto verifyEmailCode(EmailCodeRequestDto requestDto);
}
