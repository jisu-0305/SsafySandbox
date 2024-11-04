package com.ssafy.sandbox.article.service;

import com.ssafy.sandbox.article.dto.ArticleResponseDto;
import com.ssafy.sandbox.article.model.Article;
import org.springframework.data.domain.PageRequest;

import java.util.List;

public interface ArticleService {
    ArticleResponseDto getArticlesWithPagination(int size, int page);

    void createArticles(List<Article> articles);
}
