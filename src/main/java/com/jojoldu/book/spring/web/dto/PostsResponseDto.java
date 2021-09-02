package com.jojoldu.book.spring.web.dto;


import com.jojoldu.book.spring.domain.posts.Posts;
import lombok.Getter;

@Getter
public class PostsResponseDto {
    private Long id;
    private String title;
    private String content;
    private String  author;
    private String category;

    public PostsResponseDto(Posts entity){
        this.id =entity.getId();
        this.title=entity.getTitle();
        this.content=entity.getContent();
        this.author=entity.getAuthor();
        this.category=entity.getCategory();

    }

}
