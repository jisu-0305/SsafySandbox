package com.ssafy.sandbox.email.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Table(name = "email_verification")
@Entity
public class EmailVerification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;
    private String code;

    public EmailVerification(String email, String code) {
        this.email = email;
        this.code = code;
    }
}
