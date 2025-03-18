package com.acc_platform.mapper;

import com.acc_platform.model.Community;
import com.acc_platform.model.Post;
import com.acc_platform.model.Sheet;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface SheetMapper {


    @Insert("INSERT INTO sheet_music (title, description, price, upload_date, file_attachment, audio_file, reference_video, url) " +
            "VALUES (#{title}, #{description}, #{price}, NOW(), #{fileAttachment}, #{audioFile}, #{referenceVideo}, #{url})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insertSheetMusic(Sheet sheetMusic);

    @Select("SELECT * FROM sheet_music WHERE id = #{id}")
    Sheet findById(Long id);

    @Select("SELECT * FROM sheet_music ORDER BY upload_date DESC LIMIT #{size} OFFSET #{offset}")
    List<Sheet> findAll(@Param("offset") int offset, @Param("size") int size);

    @Update("UPDATE sheet_music SET title = #{title}, description = #{description}, price = #{price}, " +
            "file_attachment = #{fileAttachment}, audio_file = #{audioFile}, reference_video = #{referenceVideo}, url = #{url}, " +
            "upload_date = NOW() WHERE id = #{id}")
    int updateSheetMusic(Sheet sheetMusic);

    @Delete("DELETE FROM sheet_music WHERE id = #{id}")
    int deleteSheetMusic(Long id);
}
