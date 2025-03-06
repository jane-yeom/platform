package com.acc_platform.controller;

import com.acc_platform.model.Post;
import com.acc_platform.service.PostService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    @GetMapping("/job")
    public List<Post> getJobPosts() {
        // '구인' 유형의 게시글 목록을 조회
        return postService.getAllJobPosts();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Post> getPostById(@PathVariable Long id) {
        Post post = postService.getPostById(id);
        if (post == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(post);
    }

    @GetMapping("/community/{id}")
    public ResponseEntity<Post> getCommunityPostById(@PathVariable Long id) {
        // 게시글이 '커뮤니티' 타입인지 확인하는 로직(생략 가능)
        Post post = postService.getPostById(id);
        if (post == null || !"커뮤니티".equals(post.getType())) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(post);
    }


}
