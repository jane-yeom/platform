package com.acc_platform.service;

import com.acc_platform.mapper.CommentMapper;
import com.acc_platform.model.Comment;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CommentService {

    private final CommentMapper commentMapper;

    public CommentService(CommentMapper commentMapper) {
        this.commentMapper = commentMapper;
    }

    @Transactional
    public Comment addComment(Comment comment) {
        commentMapper.insertComment(comment);
        return comment;
    }

    public List<Comment> getCommentsByPost(Long postId, int page, int size) {
        int offset = page * size;
        return commentMapper.findCommentsByPostId(postId, offset, size);
    }

}
