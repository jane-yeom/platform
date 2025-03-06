package com.acc_platform.mapper;

import com.acc_platform.model.Post;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface PostMapper {

    @Insert("INSERT INTO posts (title, content, type, created_at, updated_at)"+
    "VALUES(#{title}, #{content}, #{type}, NOW(), NOW())")

    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insertPost(Post post);

     // 커뮤니티 게시글 페이징 조회 (type='커뮤니티')
    @Select("SELECT * FROM posts WHERE type = '커뮤니티' ORDER BY created_at DESC LIMIT #{size} OFFSET #{offset}")
    List<Post> findCommunityPosts(@Param("offset") int offset, @Param("size") int size);

    // ID로 게시글 상세 조회
    @Select("SELECT * FROM posts WHERE id = #{id}")
    Post findById(Long id);

    // 커뮤니티 게시글 수정 (type='커뮤니티'만 수정)
    @Update("UPDATE posts SET title = #{title}, content = #{content}, updated_at = NOW() " +
            "WHERE id = #{id} AND type = '커뮤니티'")
    int updateCommunityPost(Post post);

    // 커뮤니티 게시글 삭제
    @Delete("DELETE FROM posts WHERE id = #{id} AND type = '커뮤니티'")
    int deleteCommunityPost(Long id);

     @Select("SELECT * FROM posts WHERE type = #{type} ORDER BY created_at DESC")
    List<Post> findAllByType(String type);

}
