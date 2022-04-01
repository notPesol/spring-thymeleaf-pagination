package com.pesol.spring.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.pesol.spring.entity.Post;
import com.pesol.spring.repository.PostRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostRepository postRepository;

    @Value("${recordPerPage}")
    private int recordPerPage;

    @Override
    public List<Post> findAll() {
        return postRepository.findAll();
    }

    @Override
    public Post findById(int id) {
        Optional<Post> result = postRepository.findById(id);
        if (result.isPresent()) {
            return result.get();
        }
        return null;
    }

    @Override
    public Page<Post> findByPageNum(int pageNum) {

        if(pageNum < 0) {
            return new PageImpl<>(new ArrayList<>());
        }

        Pageable pageable = PageRequest.of(pageNum, recordPerPage, Sort.by("id", "title"));
        Page<Post> result = postRepository.findAll(pageable);

        return result;
    }

    @Override
    public Long count() {
        return postRepository.count();
    }
    
}
