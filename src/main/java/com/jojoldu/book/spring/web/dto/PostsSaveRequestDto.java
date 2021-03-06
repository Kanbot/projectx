package com.jojoldu.book.spring.web.dto;


import com.jojoldu.book.spring.domain.posts.Posts;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PostsSaveRequestDto {
private String title;
private String content;
private String author;
private String category;
@Builder
    public PostsSaveRequestDto(String title, String content ,String author,String category){
    this.author =author;
    this.content =content;
    this.title =title;
    this.category=category;
}

public Posts toEntity(){
    return Posts.builder().title(title).content(content).author(author).category(category).build();

}


}
