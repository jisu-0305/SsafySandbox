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

    // 인증 코드 전송 요청
    @PostMapping
    public ResponseEntity<EmailSendResponseDto> sendEmailVerification(@RequestBody EmailVerificationRequestDto emailVerificationRequestDto) {
        EmailSendResponseDto responseDto = emailService.sendEmailVerification(emailVerificationRequestDto);
        return ResponseEntity.ok(responseDto);
    }

    // 인증 코드 검증 요청
    @PostMapping("/authentication")
    public ResponseEntity<EmailVerificationResponseDto> verifyCode(@RequestBody EmailCodeRequestDto emailCodeRequestDto) {
        EmailVerificationResponseDto responseDto = emailService.verifyCode(emailCodeRequestDto);
        return ResponseEntity.ok(responseDto);
    }
}