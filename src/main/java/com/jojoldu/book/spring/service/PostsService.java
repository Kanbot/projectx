package com.jojoldu.book.spring.service;


import com.jojoldu.book.spring.domain.posts.Posts;
import com.jojoldu.book.spring.domain.posts.PostsRepository;
import com.jojoldu.book.spring.web.dto.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class PostsService {
    private final PostsRepository postsRepository;

    @Transactional
    public Long save(PostsSaveRequestDto requestDto) {
        return postsRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional
    public Long update(Long id, PostsUpdateRequestDto requestDto) {
        Posts posts = postsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 사용자가 없습니다. id=" + id));

        posts.update(requestDto.getTitle(), requestDto.getContent(),requestDto.getCategory());

        return id;
    }
    @Transactional
    public  void revise(Long id ){
        Posts posts =postsRepository.findById(id).orElseThrow(()->new IllegalArgumentException("해당 사용자가 없습니다 .id="+id));

        postsRepository.revise(id);

    }

    @Transactional
    public void delete (Long id) {
        Posts posts = postsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 사용자가 없습니다. id=" + id));

        postsRepository.delete(posts);
    }

    @Transactional(readOnly = true)
    public PostsResponseDto findById(Long id) {
        Posts entity = postsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 사용자가 없습니다. id=" + id));

        return new PostsResponseDto(entity);
    }
    @Transactional(readOnly = true)
    public List<PostsResponseDto> search(String search){
        return postsRepository.search(search).stream().map(PostsResponseDto::new).collect(Collectors.toList());

    }

    @Transactional(readOnly = true)
    public List<PostsListResponseDto> findAllDesc() {
        return postsRepository.findAllDesc().stream()
                .map(PostsListResponseDto::new)
                .collect(Collectors.toList());
    }
    @Transactional(readOnly = true)
    public List<PostsnewListDto> findCategory(String category){
        return postsRepository.findAll(category).stream().map(PostsnewListDto::new).collect(Collectors.toList());
    }


}
