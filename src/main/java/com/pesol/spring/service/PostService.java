package com.pesol.spring.service;

import java.util.List;

import com.pesol.spring.entity.Post;

import org.springframework.data.domain.Page;

public interface PostService {
    
    List<Post> findAll();

    Post findById(int id);

    Page<Post> findByPageNum(int pageNum);

    Long count();
}
