package com.acc_platform.mapper;

import com.acc_platform.model.Post;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface JobPostMapper {

    @Insert("INSERT INTO posts (title, content, type, fee_type, created_at, updated_at) " +
            "VALUES (#{title}, #{content}, '구인', #{feeType}, NOW(), NOW())")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insertPost(Post post);

    // 커뮤니티 게시글 페이징 조회 (type='커뮤니티')
    @Select("SELECT * FROM posts WHERE type = '커뮤니티' ORDER BY created_at DESC LIMIT #{size} OFFSET #{offset}")
    List<Post> findCommunityPosts(@Param("offset") int offset, @Param("size") int size);

    @Select("SELECT * FROM posts WHERE type = '구인' AND fee_type = '유료' ORDER BY created_at DESC")
    List<Post> findPaidJobPosts();

    @Select("SELECT * FROM posts WHERE type = '구인' AND fee_type = '무료' ORDER BY created_at DESC")
    List<Post> findFreeJobPosts();

    // ID로 게시글 상세 조회
    @Select("SELECT * FROM posts WHERE id = #{id} AND type = '구인'")
    Post findById(Long id);

    @Update("UPDATE posts SET title = #{title}, content = #{content}, updated_at = NOW() " +
            "WHERE id = #{id} AND type = '구인'")
    int updateJobPost(Post post);

    @Delete("DELETE FROM posts WHERE id = #{id} AND type = '구인'")
    int deleteJobPost(Long id);

    @Select("SELECT * FROM posts WHERE type = #{type} ORDER BY created_at DESC")
    List<Post> findAllByType(String type);

}
