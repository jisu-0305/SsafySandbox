package com.ssafy.sandbox.article.service;

import com.ssafy.sandbox.article.dto.ArticleCursorResponseDto;
import com.ssafy.sandbox.article.dto.ArticleOffsetResponseDto;
import com.ssafy.sandbox.article.model.Article;

import java.util.List;

public interface ArticleService {
    ArticleOffsetResponseDto getArticlesWithPagination(int size, int page);

    ArticleCursorResponseDto getArticlesWithCursor(Long cursorId, int size);

    void createArticles(List<Article> articles);
}
