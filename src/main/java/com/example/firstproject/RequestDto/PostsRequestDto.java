package com.example.firstproject.RequestDto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class PostsRequestDto {

    private String username;
    private String contents;
    private String title;
    private String password;

}
