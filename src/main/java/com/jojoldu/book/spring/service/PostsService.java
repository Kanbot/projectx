package com.jojoldu.book.spring.service;


import com.jojoldu.book.spring.domain.posts.Posts;
import com.jojoldu.book.spring.domain.posts.PostsRepository;
import com.jojoldu.book.spring.web.dto.PostsResponseDto;
import com.jojoldu.book.spring.web.dto.PostsSaveRequestDto;
import com.jojoldu.book.spring.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class PostsService {
private final PostsRepository postsRepository;
@Transactional
    public Long save (PostsSaveRequestDto requestDto){
    return postsRepository.save(requestDto.toEntity()).getId();
}
@Transactional
    public Long update(Long id , PostsUpdateRequestDto requestDto){
    Posts posts =postsRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 게시글이없습니다.id="+id));
    posts.update(requestDto.getTitle(),requestDto.getContent());
    return id;
}
public PostsResponseDto findById(Long id){
    Posts entity =postsRepository.findById(id).orElseThrow(()->new IllegalArgumentException("해당 게시글이없습니다. id="+id));
    return new PostsResponseDto(entity);
}

    @org.springframework.transaction.annotation.Transactional
    public void delete (Long id) {
        Posts posts = postsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 사용자가 없습니다. id=" + id));

        postsRepository.delete(posts);
    }
}
