package com.example.firstproject.service;


import com.example.firstproject.RequestDto.PostsRequestDto;
import com.example.firstproject.domain.Posts;
import com.example.firstproject.repository.PostsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class PostsService {

    private final PostsRepository postsRepository;

    @Transactional
    public Optional<Posts> update(Long id, PostsRequestDto requestDto) {
        Posts posts = postsRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("항목이 존재하지 않습니다.")
        );
        posts.update(requestDto);
        return postsRepository.findById(id);
    }

}