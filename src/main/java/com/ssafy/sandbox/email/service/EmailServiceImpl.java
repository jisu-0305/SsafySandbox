package com.ssafy.sandbox.email.service;

import com.ssafy.sandbox.email.dto.EmailCodeRequestDto;
import com.ssafy.sandbox.email.dto.EmailSendResponseDto;
import com.ssafy.sandbox.email.dto.EmailVerificationRequestDto;
import com.ssafy.sandbox.email.dto.EmailVerificationResponseDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
@RequiredArgsConstructor
@Slf4j
public class EmailServiceImpl implements EmailService {

    private final StringRedisTemplate redisTemplate;

    @Override
    public EmailSendResponseDto sendEmailVerification(EmailVerificationRequestDto requestDto) {
        String code = generateVerificationCode();
        redisTemplate.opsForValue().set(requestDto.getEmail(), code, 3, TimeUnit.MINUTES);
        log.info("Stored verification code '{}' for email '{}' in Redis", code, requestDto.getEmail());
        return EmailSendResponseDto.success();
    }

    @Override
    public EmailVerificationResponseDto verifyCode(EmailCodeRequestDto requestDto) {
        String storedCode = redisTemplate.opsForValue().get(requestDto.getEmail());

        log.info("Fetched verification code '{}' for email '{}' from Redis", storedCode, requestDto.getEmail());

        if (storedCode != null && storedCode.equals(requestDto.getAuthentication())) {
            return EmailVerificationResponseDto.success();
        }
        return EmailVerificationResponseDto.failure();
    }

    private String generateVerificationCode() {
        return String.valueOf(100000 + (int) (Math.random() * 900000));
    }
}
