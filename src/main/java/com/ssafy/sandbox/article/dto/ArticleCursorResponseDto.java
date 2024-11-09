package com.ssafy.sandbox.article.dto;

import com.ssafy.sandbox.article.model.Article;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
@AllArgsConstructor
public class ArticleCursorResponseDto {
    private Long lastId;
    private List<ArticleDto> articles;

    public static ArticleCursorResponseDto from(List<Article> articles) {
        Long lastId = articles.isEmpty() ? null : articles.get(articles.size() - 1).getId();
        List<ArticleDto> articleDtoList = new ArrayList<>();

        for (Article article : articles) {
            articleDtoList.add(ArticleDto.fromEntity(article));
        }
        return new ArticleCursorResponseDto(lastId, articleDtoList);
    }
}
