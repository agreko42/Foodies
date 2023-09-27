package com.foodies.backend.DTO;

import java.time.LocalDateTime;

public class RecipeCommentDTO {
    private String content;
    private LocalDateTime timestamp;
    private String author;

    public RecipeCommentDTO(String content, LocalDateTime timestamp, String author) {
        this.content = content;
        this.timestamp = timestamp;
        this.author = author;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
