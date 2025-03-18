package com.acc_platform.mapper;

import com.acc_platform.model.Post;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface JobPostMapper {

     // 유료 공고 (상단)
    @Select("SELECT * FROM job_posts WHERE is_paid = TRUE ORDER BY created_at DESC")
    List<Post> findPaidJobPosts();

    // 무료 공고 (하단)
    @Select("SELECT * FROM job_posts WHERE is_paid = FALSE ORDER BY created_at DESC")
    List<Post> findFreeJobPosts();

      // 상세페이지 정보 조회
    @Select("SELECT * FROM job_posts WHERE id = #{id}")
    Post findById(@Param("id") Long id);


    // 상세페이지 조회 시 조회수 증가
    @Update("UPDATE job_posts SET views = views + 1 WHERE id = #{id}")
    void incrementViews(@Param("id") Long id);

    @Insert("INSERT INTO job_posts (title, description, company_name, contact_info, location, salary, is_paid, expiration_date, writer, created_at) " +
            "VALUES (#{title}, #{description}, #{companyName}, #{contactInfo}, #{location}, #{salary}, #{isPaid}, #{expirationDate}, #{writer}, NOW())")
    void insertJobPost(Post jobPost);

}
