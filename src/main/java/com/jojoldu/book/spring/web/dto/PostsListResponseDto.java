package com.jojoldu.book.spring.web.dto;

import com.jojoldu.book.spring.domain.posts.Posts;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class PostsListResponseDto {
    private Long id;
    private String title;
    private String author;
    private String category;
    private LocalDateTime modifiedDate;

    public PostsListResponseDto(Posts entity) {
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.author = entity.getAuthor();
        this.category= entity.getCategory();
        this.modifiedDate = entity.getModifiedDate();
    }
}
