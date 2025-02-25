package com.acc_platform.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Post {

    private Long id;

    @NotBlank(message = "제목은 필수입니다.")
    @Size(max = 100, message = "제목은 최대 100자까지 가능합니다.")
    private String title;

    @NotBlank(message = "내용은 필수입니다.")
    private String content;

    private String type;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
