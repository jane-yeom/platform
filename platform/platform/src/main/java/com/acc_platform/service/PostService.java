package com.acc_platform.service;

import com.acc_platform.mapper.PostMapper;
import com.acc_platform.model.Post;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PostService {
    private final PostMapper postMapper;

    public PostService(PostMapper postMapper){
        this.postMapper = postMapper;

    }

    @Transactional
    public Post registerJobPost(Post post){

        post.setType("구인");
        postMapper.insertPost(post);
        return post;

    }
}
