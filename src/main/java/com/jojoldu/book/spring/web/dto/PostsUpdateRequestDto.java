package com.jojoldu.book.spring.web.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PostsUpdateRequestDto {
    private  String title;
    private String content;
    private String category;


    @Builder
    public PostsUpdateRequestDto(String title ,String content,String category){
        this.title =title;
        this.content=content;
        this.category=category;
    }
}
