package com.ssafy.sandbox.article.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import java.time.Instant;

@Getter
@AllArgsConstructor
public class ArticleDto {
    private long id;
    private String title;
    private Instant createdAt;
}