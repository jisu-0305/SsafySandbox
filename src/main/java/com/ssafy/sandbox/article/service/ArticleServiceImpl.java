package com.ssafy.sandbox.article.service;

import com.ssafy.sandbox.article.dto.ArticleDto;
import com.ssafy.sandbox.article.dto.ArticleResponseDto;
import com.ssafy.sandbox.article.model.Article;
import com.ssafy.sandbox.article.repository.ArticleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ArticleServiceImpl implements ArticleService {

    private final ArticleRepository articleRepository;

    @Override
    @Transactional(readOnly = true)
    public ArticleResponseDto getArticlesWithPagination(int size, int page) {
        Pageable pageable = PageRequest.of(page - 1, size, Sort.by(Sort.Direction.DESC, "createdAt"));

        Page<ArticleDto> articlePage = articleRepository.findAll(pageable)
                .map(article -> new ArticleDto(
                        article.getId(),
                        article.getTitle(),
                        article.getCreatedAt()));

        // Page<ArticleDto> -> ArticleResponseDto
        return new ArticleResponseDto(
                articlePage.getTotalPages(),
                articlePage.getContent()
        );
    }

    @Override
    @Transactional
    public void createArticles(List<Article> articles) {
        articleRepository.saveAll(articles);
    }
}
