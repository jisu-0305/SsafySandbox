package com.ssafy.sandbox.article.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;


@Getter
@AllArgsConstructor
public class ArticleCursorResponseDto {
    private Long lastId;
    private List<ArticleDto> articles;
}

