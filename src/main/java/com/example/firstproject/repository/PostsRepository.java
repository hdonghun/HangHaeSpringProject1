package com.example.firstproject.repository;


import com.example.firstproject.domain.Posts;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostsRepository extends JpaRepository<Posts, Long> {

    List<Posts> findAllByOrderByCreatedAtDesc();

}