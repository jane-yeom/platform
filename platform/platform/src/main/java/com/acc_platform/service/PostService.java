package com.acc_platform.service;

import com.acc_platform.mapper.PostMapper;
import com.acc_platform.model.Post;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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

    public List<Post> getAllJobPosts() {
        // Mapper에서 type='구인'인 게시글 전부 조회
        return postMapper.findAllByType("구인");
    }

    public Post getPostById(Long id) {
        return postMapper.findById(id);
    }
}
