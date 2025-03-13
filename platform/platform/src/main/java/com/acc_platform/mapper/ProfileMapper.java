package com.acc_platform.mapper;

import com.acc_platform.model.Profile;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ProfileMapper {

    @Insert("INSERT INTO profiles (name, skill, instrument, content, portfolio_url, availability, region, created_at, updated_at) " +
            "VALUES (#{name}, #{skill}, #{instrument}, #{content}, #{portfolioUrl}, #{availability}, #{region}, NOW(), NOW())")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insertProfile(Profile profile);
    @Select("SELECT * FROM profiles ORDER BY created_at DESC")
    List<Profile> findAllProfiles();
    @Select("SELECT * FROM profiles WHERE id = #{id}")
    Profile findProfileById(Long id);

    @Update("UPDATE profiles SET name = #{name}, skill = #{skill}, instrument = #{instrument}, content = #{content}, " +
            "portfolio_url = #{portfolioUrl}, availability = #{availability}, region = #{region}, updated_at = NOW() " +
            "WHERE id = #{id}")
    int updateProfile(Profile profile);



}
