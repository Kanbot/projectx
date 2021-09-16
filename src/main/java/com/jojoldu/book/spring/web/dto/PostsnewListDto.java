package com.jojoldu.book.spring.web.dto;

import com.jojoldu.book.spring.domain.posts.Posts;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class PostsnewListDto {
    private Long id;
    private String title;
    private String content;
    private String author;
    private LocalDateTime modifiedDate;
    private String category;

   public   PostsnewListDto(Posts entity){
        this.id =entity.getId();
        this.title=entity.getTitle();
        this.content=entity.getContent();
        this.author=entity.getAuthor();
        this.modifiedDate=entity.getModifiedDate();
        this.category=entity.getCategory();

    }
}
