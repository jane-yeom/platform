package com.acc_platform.controller;

import com.acc_platform.model.Post;
import com.acc_platform.service.JobPostService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
public class JobPostController {
    private final JobPostService jobPostService;

    public JobPostController(JobPostService jobPostService){
        this.jobPostService = jobPostService;

    }

     // 구인 공고 등록 (POST /api/posts/job)
    @PostMapping("/job")
    public ResponseEntity<Post> createJobPost(@Validated @RequestBody Post post) {
        Post createdPost = jobPostService.registerJobPost(post);
        return ResponseEntity.ok(createdPost);
    }

    // 유료 구인 공고 목록 (GET /api/posts/job/paid)
    @GetMapping("/job/paid")
    public ResponseEntity<List<Post>> getPaidJobPosts() {
        List<Post> posts = jobPostService.getPaidJobPosts();
        return ResponseEntity.ok(posts);
    }

    // 무료 구인 공고 목록 (GET /api/posts/job/free)
    @GetMapping("/job/free")
    public ResponseEntity<List<Post>> getFreeJobPosts() {
        List<Post> posts = jobPostService.getFreeJobPosts();
        return ResponseEntity.ok(posts);
    }

    // 구인 공고 상세 조회 (GET /api/posts/job/{id})
    @GetMapping("/job/{id}")
    public ResponseEntity<Post> getJobPostById(@PathVariable Long id) {
        Post post = jobPostService.getJobPostById(id);
        if (post == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(post);
    }

    // 구인 공고 수정 (PUT /api/posts/job/{id})
    @PutMapping("/job/{id}")
    public ResponseEntity<Post> updateJobPost(@PathVariable Long id, @Validated @RequestBody Post post) {
        Post updated = jobPostService.updateJobPost(id, post);
        return ResponseEntity.ok(updated);
    }

    // 구인 공고 삭제 (DELETE /api/posts/job/{id})
    @DeleteMapping("/job/{id}")
    public ResponseEntity<Void> deleteJobPost(@PathVariable Long id) {
        jobPostService.deleteJobPost(id);
        return ResponseEntity.noContent().build();
    }

}
