package com.ssafy.sandbox.article.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Entity
@Table(name = "articles")
@Getter
@NoArgsConstructor
public class Article {
    @Id
    private long id;
    @Column(nullable = false)
    private String title;
    @Column(nullable = false)
    private Instant createdAt;

    private Article(long id, String title, Instant createdAt) {
        this.id = id;
        this.title = title;
        this.createdAt = createdAt;
    }

    public static Article of(long id, String title, Instant createdAt){
        return new Article(id, title, createdAt);
    }
}
