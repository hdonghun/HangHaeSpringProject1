package com.example.firstproject.domain;

import java.time.LocalDateTime;


public interface PostMapping {
    String getUsername();
    String getTitle();
    LocalDateTime getCreatedAt();
}