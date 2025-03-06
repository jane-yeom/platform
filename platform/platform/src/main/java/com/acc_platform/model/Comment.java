package com.acc_platform.model;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Comment {

    private Long id;
    private Long postId;

    @NotBlank(message = "댓글 내용은 필수입니다.")
    private String content;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
