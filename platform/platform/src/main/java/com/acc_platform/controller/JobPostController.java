package com.acc_platform.controller;

import com.acc_platform.model.Post;
import com.acc_platform.service.JobPostService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
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

     @PostMapping("/register")
    public ResponseEntity<?> registerJobPost(@RequestBody Post jobPost,
                                             @AuthenticationPrincipal UserDetails userDetails) {
        if (userDetails == null) {
            return ResponseEntity.status(401).body("{\"success\": false, \"message\": \"로그인이 필요합니다.\"}");
        }

        String username = userDetails.getUsername(); // 로그인한 사용자 이름 가져오기
        jobPost.setWriter(username); // 작성자 자동 설정

        jobPostService.createJobPost(jobPost);
        return ResponseEntity.ok().body("{\"success\": true}");
    }



}
