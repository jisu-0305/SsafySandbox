package com.ssafy.sandbox.email.controller;

import com.ssafy.sandbox.email.dto.EmailCodeRequestDto;
import com.ssafy.sandbox.email.dto.EmailVerificationRequestDto;
import com.ssafy.sandbox.email.dto.EmailSendResponseDto;
import com.ssafy.sandbox.email.dto.EmailVerificationResponseDto;
import com.ssafy.sandbox.email.service.EmailService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/email")
@RequiredArgsConstructor
public class EmailController {

    private final EmailService emailService;

    @PostMapping
    public ResponseEntity<EmailSendResponseDto> sendEmailVerification(@RequestBody EmailVerificationRequestDto emailVerificationRequestDto) {
        EmailSendResponseDto emailSendResponseDto = emailService.sendEmailVerification(emailVerificationRequestDto);
        return ResponseEntity.ok(emailSendResponseDto);
    }

    @PostMapping("/authentication")
    public ResponseEntity<EmailVerificationResponseDto> verifyEmailCode(@RequestBody EmailCodeRequestDto emailCodeRequestDto) {
        EmailVerificationResponseDto emailVerificationResponseDto = emailService.verifyEmailCode(emailCodeRequestDto);
        return ResponseEntity.ok(emailVerificationResponseDto);
    }
}