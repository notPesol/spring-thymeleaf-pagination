package com.pesol.spring.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import com.pesol.spring.entity.Post;
import com.pesol.spring.service.PostService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/posts")
public class PostController {
    
    @Autowired
    private PostService postService;

    @GetMapping()
    public String postIndex(@RequestParam Optional<Integer> page, Model model) {

        int pageNum = page.orElse(1);

        Page<Post> pages = postService.findByPageNum(pageNum - 1);

        model.addAttribute("postPage", pages);

        int totalPages = pages.getTotalPages();
        if (totalPages > 0) {
            List<Integer> pageNumbers = 
                    IntStream.rangeClosed(1, totalPages)
                            .boxed()
                            .collect(Collectors.toList());
            model.addAttribute("pageNumbers", pageNumbers);
        }        
        return "post/index";
    }

    @GetMapping("/{id}")
    public String getById(@PathVariable int id, Model model) {

        Post post = postService.findById(id);

        if(post == null) {
            return "redirect:/posts";
        }

        model.addAttribute("post", post);

        return "post/detail";
    }
}
