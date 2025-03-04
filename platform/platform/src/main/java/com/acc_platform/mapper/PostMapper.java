package com.acc_platform.mapper;

import com.acc_platform.model.Post;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface PostMapper {

    @Insert("INSERT INTO posts (title, content, type, created_at, updated_at)"+
    "VALUES(#{title}, #{content}, #{type}, NOW(), NOW())")

    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insertPost(Post post);

    @Select("SELECT * FROM posts WHERE type = #{type} ORDER BY created_at DESC")
    List<Post> findAllByType(String type);

    @Select("SELECT * FROM posts WHERE id = #{id}")
    Post findById(Long id);

}
