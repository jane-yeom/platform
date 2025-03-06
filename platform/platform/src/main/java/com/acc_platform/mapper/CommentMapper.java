package com.acc_platform.mapper;

import com.acc_platform.model.Comment;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface CommentMapper {
    @Select("SELECT * FROM comments WHERE post_id = #{postId} ORDER BY created_at ASC LIMIT #{size} OFFSET #{offset}")
    List<Comment> findCommentsByPostId(@Param("postId") Long postId,
                                       @Param("offset") int offset,
                                       @Param("size") int size);

    @Insert("INSERT INTO comments (post_id, content, created_at, updated_at) VALUES (#{postId}, #{content}, NOW(), NOW())")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insertComment(Comment comment);
}
