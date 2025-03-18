package com.acc_platform.controller;

import com.acc_platform.model.Community;
import com.acc_platform.service.CommunityService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/community")
public class CommunityController {

    private final CommunityService communityPostService;

    public CommunityController(CommunityService communityPostService) {
        this.communityPostService = communityPostService;
    }

    // 커뮤니티 게시글 등록
    @PostMapping("/posts")
    public ResponseEntity<Community> createCommunityPost(@Validated @RequestBody Community post) {
        Community created = communityPostService.registerCommunityPost(post);
        return ResponseEntity.ok(created);
    }

    // 커뮤니티 게시글 목록 (페이징)
    @GetMapping("/posts")
    public ResponseEntity<List<Community>> getCommunityPosts(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        List<Community> posts = communityPostService.getCommunityPosts(page, size);
        return ResponseEntity.ok(posts);
    }

    // 커뮤니티 게시글 상세 조회
    @GetMapping("/posts/{id}")
    public ResponseEntity<Community> getCommunityPost(@PathVariable Long id) {
        Community post = communityPostService.getCommunityPostById(id);
        if (post == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(post);
    }

    // 커뮤니티 게시글 수정
    @PutMapping("/posts/{id}")
    public ResponseEntity<Community> updateCommunityPost(@PathVariable Long id, @Validated @RequestBody Community post) {
        Community updated = communityPostService.updateCommunityPost(id, post);
        return ResponseEntity.ok(updated);
    }

    // 커뮤니티 게시글 삭제
    @DeleteMapping("/posts/{id}")
    public ResponseEntity<Void> deleteCommunityPost(@PathVariable Long id) {
        communityPostService.deleteCommunityPost(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/latest")
    public List<Community> getLatestCommunityPosts() {
        return communityPostService.getLatestPosts();
    }
}
