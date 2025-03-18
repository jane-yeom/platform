package com.acc_platform.controller;

import com.acc_platform.model.Community;
import com.acc_platform.model.Sheet;
import com.acc_platform.service.CommunityService;
import com.acc_platform.service.SheetService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sheet")
public class SheetController {

    private final SheetService sheetService;

    public SheetController(SheetService sheetService) {
        this.sheetService = sheetService;
    }

    // 커뮤니티 게시글 등록
    @PostMapping("/posts")
    public ResponseEntity<Sheet> createSheetPost(@Validated @RequestBody Sheet post) {
        Sheet created = sheetService.registerSheetPost(post);
        return ResponseEntity.ok(created);
    }

    // 커뮤니티 게시글 목록 (페이징)
    @GetMapping("/posts")
    public ResponseEntity<List<Sheet>> findAll(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        List<Sheet> posts = sheetService.findAll(page, size);
        return ResponseEntity.ok(posts);
    }

    // 커뮤니티 게시글 상세 조회
    @GetMapping("/posts/{id}")
    public ResponseEntity<Sheet> getSheetPost(@PathVariable Long id) {
        Sheet post = sheetService.getSheetPostById(id);
        if (post == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(post);
    }

    // 커뮤니티 게시글 수정
    @PutMapping("/posts/{id}")
    public ResponseEntity<Sheet> updateSheetMusic(@PathVariable Long id, @Validated @RequestBody Sheet post) {
        Sheet updated = sheetService.updateSheetMusic(id, post);
        return ResponseEntity.ok(updated);
    }

    // 커뮤니티 게시글 삭제
    @DeleteMapping("/posts/{id}")
    public ResponseEntity<Void> deleteSheetMusic(@PathVariable Long id) {
        sheetService.deleteSheetMusic(id);
        return ResponseEntity.noContent().build();
    }
}
