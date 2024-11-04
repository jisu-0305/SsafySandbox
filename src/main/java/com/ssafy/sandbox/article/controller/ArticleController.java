package com.ssafy.sandbox.article.controller;

import com.ssafy.sandbox.article.dto.ArticleCursorResponseDto;
import com.ssafy.sandbox.article.dto.ArticleRequestDto;
import com.ssafy.sandbox.article.dto.ArticleOffsetResponseDto;
import com.ssafy.sandbox.article.service.ArticleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/articles")
@RequiredArgsConstructor
public class ArticleController {

    private final ArticleService articleService;

    @GetMapping("/paging/offset")
    public ResponseEntity<ArticleOffsetResponseDto> getArticlesByOffset(
            @RequestParam(name = "size", defaultValue = "10", required = false) int size,
            @RequestParam(name = "page", defaultValue = "0", required = false) int page) {
        ArticleOffsetResponseDto response = articleService.getArticlesWithPagination(size, page);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/paging/cursor")
    public ResponseEntity<ArticleCursorResponseDto> getArticlesByCursor(
            @RequestParam(name = "cursorId", required = false) Long cursorId,
            @RequestParam(name = "size", defaultValue = "10") int size) {

        ArticleCursorResponseDto response = articleService.getArticlesWithCursor(cursorId, size);
        return ResponseEntity.ok(response);
    }
    @PostMapping("/make")
    public ResponseEntity<Void> createArticles(@RequestBody ArticleRequestDto articleRequestDto) {
        articleService.createArticles(articleRequestDto.getArticles());
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
