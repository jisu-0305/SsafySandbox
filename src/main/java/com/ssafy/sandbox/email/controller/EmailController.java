package com.ssafy.sandbox.email.controller;

import com.ssafy.sandbox.email.service.EmailService;
import com.ssafy.sandbox.todo.dto.TodoRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/email")
@RequiredArgsConstructor
public class EmailController {
    private final EmailService emailService;

    @PostMapping
    public ResponseEntity<Map<String, Boolean>> sendEmail(@RequestBody TodoRequestDto requestDto) {
        boolean isSent = emailService.sendEmailVerification(emailRequestDto.getEmail());
        return ResponseEntity.ok().body(Map.of("isOk", isSent));
    }
}