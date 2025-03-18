package com.acc_platform.mapper;

import com.acc_platform.model.Community;
import com.acc_platform.model.Post;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface CommunityMapper {

    @Insert("INSERT INTO community (title, content, views, likes, created_at, updated_at) " +
            "VALUES (#{title}, #{content}, 0, 0, NOW(), NOW())")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insertCommunityPost(Community post);

    @Select("SELECT * FROM community WHERE id = #{id}")
    Community findCommunityPostById(Long id);

    @Select("SELECT * FROM community ORDER BY created_at DESC LIMIT #{size} OFFSET #{offset}")
    List<Community> findCommunityPosts(@Param("offset") int offset, @Param("size") int size);

    @Update("UPDATE community SET title = #{title}, content = #{content}, updated_at = NOW() " +
            "WHERE id = #{id}")
    int updateCommunityPost(Community post);

    @Delete("DELETE FROM community WHERE id = #{id}")
    int deleteCommunityPost(Long id);

    @Select("SELECT * FROM community ORDER BY created_at DESC LIMIT 5")
    List<Community> findLatestPosts();
}
