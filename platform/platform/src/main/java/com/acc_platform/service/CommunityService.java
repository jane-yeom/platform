package com.acc_platform.service;

import com.acc_platform.mapper.CommunityMapper;
import com.acc_platform.model.Community;
import com.acc_platform.model.Post;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CommunityService {
     private final CommunityMapper communityMapper;

    public CommunityService(CommunityMapper communityMapper) {
        this.communityMapper = communityMapper;
    }

    @Transactional
    public Community registerCommunityPost(Community post) {
        communityMapper.insertCommunityPost(post);
        return post;
    }

    public Community getCommunityPostById(Long id) {
        return communityMapper.findCommunityPostById(id);
    }

    public List<Community> getCommunityPosts(int page, int size) {
        int offset = page * size;
        return communityMapper.findCommunityPosts(offset, size);
    }

    @Transactional
    public Community updateCommunityPost(Long id, Community updatedPost) {
        Community existing = communityMapper.findCommunityPostById(id);
        if (existing == null) {
            throw new RuntimeException("게시글이 존재하지 않습니다.");
        }
        existing.setTitle(updatedPost.getTitle());
        existing.setContent(updatedPost.getContent());
        communityMapper.updateCommunityPost(existing);
        return existing;
    }

    @Transactional
    public void deleteCommunityPost(Long id) {
        Community existing = communityMapper.findCommunityPostById(id);
        if (existing == null) {
            throw new RuntimeException("게시글이 존재하지 않습니다.");
        }
        communityMapper.deleteCommunityPost(id);
    }

    public List<Community> getLatestPosts() {
        return communityMapper.findLatestPosts();
    }
}
