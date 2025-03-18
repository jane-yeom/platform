package com.acc_platform.service;

import com.acc_platform.mapper.CommunityMapper;
import com.acc_platform.mapper.SheetMapper;
import com.acc_platform.model.Community;
import com.acc_platform.model.Post;
import com.acc_platform.model.Sheet;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class SheetService {
     private final SheetMapper sheetMapper;

    public SheetService(SheetMapper sheetMapper) {
        this.sheetMapper = sheetMapper;
    }

    @Transactional
    public Sheet registerSheetPost(Sheet sheet) {
        sheetMapper.insertSheetMusic(sheet);
        return sheet;
    }

    public Sheet getSheetPostById(Long id) {
        return sheetMapper.findById(id);
    }

    public List<Sheet> findAll(int page, int size) {
        int offset = page * size;
        return sheetMapper.findAll(offset, size);
    }

    @Transactional
    public Sheet updateSheetMusic(Long id, Sheet updatedPost) {
        Sheet existing = sheetMapper.findById(id);
        if (existing == null) {
            throw new RuntimeException("게시글이 존재하지 않습니다.");
        }
        existing.setTitle(updatedPost.getTitle());
        existing.setDescription(updatedPost.getDescription());
        sheetMapper.updateSheetMusic(existing);
        return existing;
    }

    @Transactional
    public void deleteSheetMusic(Long id) {
        Sheet existing = sheetMapper.findById(id);
        if (existing == null) {
            throw new RuntimeException("게시글이 존재하지 않습니다.");
        }
        sheetMapper.deleteSheetMusic(id);
    }
}
