package com.acc_platform.mapper;

import com.acc_platform.model.Post;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;

@Mapper
public interface PostMapper {

    @Insert("INSERT INTO posts (title, content, type, created_at, updated_at)"+
    "VALUES(#{title}, #{content}, #{type}, NOW(), NOW())")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insertPost(Post post);
}
