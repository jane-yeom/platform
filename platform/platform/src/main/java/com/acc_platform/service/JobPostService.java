package com.acc_platform.service;

import com.acc_platform.mapper.JobPostMapper;
import com.acc_platform.model.Post;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class JobPostService {
    private final JobPostMapper jobPostMapper;

    public JobPostService(JobPostMapper jobPostMapper){
        this.jobPostMapper = jobPostMapper;

    }

    @Transactional
    public Post registerJobPost(Post post){

        post.setType("구인");
        jobPostMapper.insertPost(post);
        return post;

    }

    public List<Post> getPaidJobPosts() {
        return jobPostMapper.findPaidJobPosts();
    }

    public List<Post> getFreeJobPosts() {
        return jobPostMapper.findFreeJobPosts();
    }

    public List<Post> getAllJobPosts() {
        // "구인"이라는 문자열을 파라미터로 넘겨줍니다.
        return jobPostMapper.findAllByType("구인");
    }

    public Post getJobPostById(Long id) {
        Post post = jobPostMapper.findById(id);
        if (post != null && "구인".equals(post.getType())) {
            return post;
        }
        return null;
    }

     @Transactional
    public Post updateJobPost(Long id, Post updatedPost) {
        Post existing = jobPostMapper.findById(id);
        if (existing == null || !"구인".equals(existing.getType())) {
            throw new RuntimeException("Job post not found or invalid type");
        }
        existing.setTitle(updatedPost.getTitle());
        existing.setContent(updatedPost.getContent());
        jobPostMapper.updateJobPost(existing);
        return existing;
    }

    @Transactional
    public void deleteJobPost(Long id) {
        Post existing = jobPostMapper.findById(id);
        if (existing == null || !"구인".equals(existing.getType())) {
            throw new RuntimeException("Job post not found or invalid type");
        }
        jobPostMapper.deleteJobPost(id);
    }

}
