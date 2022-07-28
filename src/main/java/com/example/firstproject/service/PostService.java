package com.example.firstproject.service;

import com.example.firstproject.RequestDto.PwRequestDto;
import com.example.firstproject.domain.Posts;
import com.example.firstproject.repository.PostsRepository;
import com.example.firstproject.RequestDto.PostsRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class PostService {

    private final PostsRepository postsRepository;


    @Autowired
    public PostService(PostsRepository postsRepository) {
        this.postsRepository = postsRepository;
    }

    public Long post(PostsRequestDto requestDto) {
        String username = requestDto.getUsername();
        String title = requestDto.getTitle();
        String contents = requestDto.getContents();
        String password = requestDto.getPassword();

        Posts post = new Posts(username, title, contents, password);
        postsRepository.save(post);
        return post.getId();
    }

    public boolean checkPassword(Long id, PwRequestDto password) {

        Posts posts = postsRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("id가 없습니다.")
        );
        return posts.getPassword().equals(password.getPassword());
    }

}