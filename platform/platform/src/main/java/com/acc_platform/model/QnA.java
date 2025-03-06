package com.acc_platform.model;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class QnA {
    private Long id;

    @NotBlank(message = "문의 제목은 필수입니다.")
    private String title;

    @NotBlank(message = "문의 내용은 필수입니다.")
    private String content;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
