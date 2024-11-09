package com.ssafy.sandbox.article.repository;

import com.ssafy.sandbox.article.model.Article;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Long> {
    @Query("SELECT a FROM Article a ORDER BY a.createdAt DESC")
    List<Article> findTopArticlesByOrderByCreatedAtDesc(Pageable pageable);

    @Query("SELECT a FROM Article a WHERE a.id > :cursorId ORDER BY a.createdAt DESC")
    List<Article> findArticlesNextPage(@Param("cursorId") Long cursorId, Pageable pageable);
}
