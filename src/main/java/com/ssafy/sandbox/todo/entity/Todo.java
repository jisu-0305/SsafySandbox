package com.ssafy.sandbox.todo.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "todos") //테이블 이름 지정
@Getter
@NoArgsConstructor
public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String content;
    private boolean completed;

    private Todo(String content) {
        this.content = content;
        this.completed = false;
    }

    public static Todo of(String content) {
        return new Todo(content);
    }

    public void toggleCompleted() {
        this.completed = !this.completed;
    }
}