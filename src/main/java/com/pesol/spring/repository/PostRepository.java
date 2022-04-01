package com.pesol.spring.repository;

import com.pesol.spring.entity.Post;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Integer> {
    
}
