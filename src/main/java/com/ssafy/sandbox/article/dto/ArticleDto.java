package com.ssafy.sandbox.article.dto;

import com.ssafy.sandbox.article.model.Article;
import lombok.AllArgsConstructor;
import lombok.Getter;
import java.time.Instant;

@Getter
@AllArgsConstructor
public class ArticleDto {
    private long id;
    private String title;
    private Instant createdAt;

    public static ArticleDto fromEntity(Article article) {
        return new ArticleDto(article.getId(), article.getTitle(), article.getCreatedAt());
    }
}