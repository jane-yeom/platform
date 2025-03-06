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
        // "구인"이라는 문자열을 파라미터로 넘겨줍니다.
        return postMapper.findAllByType("구인");
    }
    public List<Post> getCommunityPosts(int page, int size) {
        int offset = page * size;
        return postMapper.findCommunityPosts(offset, size);
    }

    public Post getPostById(Long id) {
        return postMapper.findById(id);
    }

    @Transactional
    public Post updateCommunityPost(Long id, Post updatedPost) {
        Post existingPost = postMapper.findById(id);
        if (existingPost == null || !"커뮤니티".equals(existingPost.getType())) {
            throw new RuntimeException("게시글이 존재하지 않거나 커뮤니티 게시글이 아닙니다.");
        }
        existingPost.setTitle(updatedPost.getTitle());
        existingPost.setContent(updatedPost.getContent());
        postMapper.updateCommunityPost(existingPost);
        return existingPost;
    }

    @Transactional
    public void deleteCommunityPost(Long id) {
        Post existingPost = postMapper.findById(id);
        if (existingPost == null || !"커뮤니티".equals(existingPost.getType())) {
            throw new RuntimeException("게시글이 존재하지 않거나 커뮤니티 게시글이 아닙니다.");
        }
        postMapper.deleteCommunityPost(id);
    }

}
