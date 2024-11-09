package com.ssafy.sandbox.article.dto;

import com.ssafy.sandbox.article.model.Article;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
public class ArticleRequestDto {
    private List<Article> articles;
}