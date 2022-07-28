package com.example.firstproject.repository;


import com.example.firstproject.domain.PostMapping;
import com.example.firstproject.domain.Posts;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostMapRepository extends JpaRepository<Posts, Long> {
    List<PostMapping> findAllByOrderByCreatedAtDesc();
}