package com.acc_platform.model;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Profile {
    private Long id;

    @NotBlank(message = "이름은 필수입니다.")
    private String name;

    private String skill;
    private String instrument;
    private String content;
    private String portfolioUrl;   // 포트폴리오 URL
    private String availability;   // 활동 가능 시간
    private String region;         // 활동 가능 지역

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

}
