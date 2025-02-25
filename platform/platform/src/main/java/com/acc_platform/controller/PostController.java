package com.acc_platform.controller;

import com.acc_platform.model.Post;
import com.acc_platform.service.PostService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/posts")
public class PostController {
    private final PostService postService;

    public PostController(PostService postService){
        this.postService = postService;

    }

    @PostMapping("/job")
    public ResponseEntity<Post> createJobPost(@Validated @RequestBody Post post){
        Post createdPost = postService.registerJobPost(post);
        return ResponseEntity.ok(createdPost);

    }
}
