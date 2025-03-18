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


    public List<Post> getPaidJobPosts() {
        return jobPostMapper.findPaidJobPosts();
    }

    public List<Post> getFreeJobPosts() {
        return jobPostMapper.findFreeJobPosts();
    }



    public Post getJobPostById(Long id) {
        Post post = jobPostMapper.findById(id);
        if (post != null && "구인".equals(post.getType())) {
            return post;
        }
        return null;
    }

    public void createJobPost(Post jobPost) {
        jobPostMapper.insertJobPost(jobPost);
    }



}
