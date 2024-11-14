package com.ssafy.sandbox.email.service;

import com.ssafy.sandbox.email.dto.EmailCodeRequestDto;
import com.ssafy.sandbox.email.dto.EmailSendResponseDto;
import com.ssafy.sandbox.email.dto.EmailVerificationRequestDto;
import com.ssafy.sandbox.email.dto.EmailVerificationResponseDto;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
@RequiredArgsConstructor
@Slf4j
public class EmailServiceImpl implements EmailService {
    private final JavaMailSender mailSender;
    private final StringRedisTemplate redisTemplate;

    @Override
    public EmailSendResponseDto sendEmailVerification(EmailVerificationRequestDto requestDto) {
        String code = generateVerificationCode();

        try {
            sendVerificationEmail(requestDto.getEmail(), code);
        } catch (MessagingException e) {
            log.error("fail to send email");
            return EmailSendResponseDto.failure();
        }

        redisTemplate.opsForValue().set(requestDto.getEmail(), code, 3, TimeUnit.MINUTES);
        log.info("stored code: " + code);
        return EmailSendResponseDto.success();
    }

    @Override
    public EmailVerificationResponseDto verifyCode(EmailCodeRequestDto requestDto) {
        String storedCode = redisTemplate.opsForValue().get(requestDto.getEmail());

        if (storedCode != null && storedCode.equals(requestDto.getAuthentication())) {
            return EmailVerificationResponseDto.success();
        }
        return EmailVerificationResponseDto.failure();
    }

    private void sendVerificationEmail(String email, String code) throws MessagingException {
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);

        helper.setTo(email);
        helper.setFrom("comjisu0311@naver.com");
        helper.setSubject("Verification Code");
        helper.setText("Your verification code: " + code);

        mailSender.send(message);
    }

    private String generateVerificationCode() {
        return String.valueOf(100000 + (int) (Math.random() * 900000));
    }
}
