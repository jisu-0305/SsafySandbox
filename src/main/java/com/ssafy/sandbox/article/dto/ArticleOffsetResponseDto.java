package com.ssafy.sandbox.article.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.data.domain.Page;

import java.util.List;

@Getter
@AllArgsConstructor
public class ArticleOffsetResponseDto {
    private int totalPage;
    private List<ArticleDto> articles;

    public static ArticleOffsetResponseDto from(Page<ArticleDto> page) {
        return new ArticleOffsetResponseDto(page.getTotalPages(), page.getContent());
    }
}
