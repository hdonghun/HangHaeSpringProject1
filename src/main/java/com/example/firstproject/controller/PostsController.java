package com.example.firstproject.controller;

import com.example.firstproject.RequestDto.PwRequestDto;
import com.example.firstproject.domain.Posts;
import com.example.firstproject.repository.PostMapRepository;
import com.example.firstproject.repository.PostsRepository;
import com.example.firstproject.RequestDto.PostsRequestDto;
import com.example.firstproject.service.PostService;
import com.example.firstproject.service.PostsService;
import com.example.firstproject.utils.ApiResult;
import com.example.firstproject.utils.ApiUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class PostsController {

    private final PostMapRepository postMapRepository;
    private final PostsRepository postsRepository;
    private final PostService postService;
    private final PostsService postsService;



    @GetMapping("/api/post")
    public List<Posts> readPosts() {

        return postsRepository.findAllByOrderByCreatedAtDesc();
    }

    @GetMapping("/api/post/{id}")
    public ApiResult<?> successApiFormat(@PathVariable Long id) {
        if (postsRepository.findById(id).isPresent()) {
            return ApiUtils.success(postsRepository.findById(id));
        } else {
            return ApiUtils.error(postsRepository.findById(id), "해당 게시물을 찾을 수 없습니다.");
        }
    }


    @PostMapping("/api/post")
    public ApiResult<?> createPosts(@RequestBody PostsRequestDto requestDto){
        return ApiUtils.success(postsRepository.findById(postService.post(requestDto)));
    }

    @PostMapping("/api/post/{id}")
    public ApiResult<Boolean> checkpw(@RequestBody PwRequestDto password, @PathVariable Long id){
        System.out.println(password);
        boolean result = postService.checkPassword(id, password);
        if (result) {
            return ApiUtils.success(true);
        } else {
            return ApiUtils.error(false, "비밀번호가 틀렸습니다.");
        }
    }


    @DeleteMapping("/api/post/{id}")
    public ApiResult<Boolean> deletePosts( @PathVariable Long id, @RequestBody PwRequestDto password){
        if(postService.checkPassword(id, password)) {
            postsRepository.deleteById(id);
            return ApiUtils.success(true);
        } else{return ApiUtils.error(postService.checkPassword(id, password),"비밀번호가 틀렸습니다.");
        }
    }


    @PatchMapping("/api/post/{id}")
    public ApiResult<?> updatePosts(@RequestBody PwRequestDto password, @PathVariable Long id, @RequestBody PostsRequestDto requestDto){
        if(postService.checkPassword(id, password)) {
            return ApiUtils.success(postsService.update(id,requestDto));
        }else{
            return ApiUtils.error(postService.checkPassword(id, password),"비밀번호가 틀렸습니다.");
        }

    }
}