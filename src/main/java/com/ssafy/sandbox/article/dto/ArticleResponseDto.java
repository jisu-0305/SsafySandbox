package com.ssafy.sandbox.article.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import java.time.Instant;
import java.util.List;

@Getter
@AllArgsConstructor
public class ArticleResponseDto {
    private int totalPage;
    private List<ArticleDto> articles;
}
