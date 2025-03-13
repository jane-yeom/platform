package com.acc_platform.mapper;

import com.acc_platform.model.Member;
import org.apache.ibatis.annotations.*;

@Mapper
public interface MemberMapper {

    @Insert("INSERT INTO users (username, email, password, phone, major, role, note_grade, highSchool, college, graduate, created_at, updated_at) " +
            "VALUES (#{username}, #{email}, #{password}, #{phone}, #{major}, #{role}, #{noteGrade}, #{highSchool}, #{college}, #{graduate}, NOW(), NOW())")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insertMember(Member member);

    @Select("SELECT * FROM users WHERE id = #{id}")
    Member findMemberById(Long id);

    @Select("SELECT * FROM users WHERE email = #{email}")
    Member findMemberByEmail(String email);

    // 필요 시 업데이트, 목록 조회 등 추가
}
