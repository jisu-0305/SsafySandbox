package com.ssafy.sandbox.email.service;

import com.ssafy.sandbox.email.dto.EmailCodeRequestDto;
import com.ssafy.sandbox.email.dto.EmailSendResponseDto;
import com.ssafy.sandbox.email.dto.EmailVerificationRequestDto;
import com.ssafy.sandbox.email.dto.EmailVerificationResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
@RequiredArgsConstructor
public class EmailServiceImpl implements EmailService {

    private final StringRedisTemplate redisTemplate;

    // 이메일 인증 코드 전송 로직
    @Override
    public EmailSendResponseDto sendEmailVerification(EmailVerificationRequestDto requestDto) {
        String code = generateVerificationCode();
        redisTemplate.opsForValue().set(requestDto.getEmail(), code, 3, TimeUnit.MINUTES);

        // 실제 이메일 전송 로직이 들어갈 부분
        return EmailSendResponseDto.success();
    }

    // 인증 코드 검증 로직
    @Override
    public EmailVerificationResponseDto verifyCode(EmailCodeRequestDto requestDto) {
        String storedCode = redisTemplate.opsForValue().get(requestDto.getEmail());
        if (storedCode != null && storedCode.equals(requestDto.getCode())) {
            return EmailVerificationResponseDto.success();
        }
        return EmailVerificationResponseDto.failure();
    }

    // 인증 코드 생성 메서드
    private String generateVerificationCode() {
        return String.valueOf(100000 + (int) (Math.random() * 900000)); // 6자리 난수 생성
    }
}
