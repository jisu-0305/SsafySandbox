package com.ssafy.sandbox.article.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import java.util.List;

@Getter
@AllArgsConstructor
public class ArticleOffsetResponseDto {
    private int totalPage;
    private List<ArticleDto> articles;
}
