package com.acc_platform.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class Sheet {
    private Long id;

    @NotBlank(message = "제목은 필수입니다.")
    private String title;

    @NotBlank(message = "설명은 필수입니다.")
    private String description;

    // 금액 (예: 판매가격)
    @NotNull(message = "금액은 필수입니다.")
    private BigDecimal price;

    // 업로드 날짜 (자동 설정 가능)
    private LocalDateTime uploadDate;

    // 파일 첨부 (필수, 실제 파일 경로나 URL로 저장)
    @NotBlank(message = "파일 첨부는 필수입니다.")
    private String fileAttachment;

    // 음원 파일 (옵션: 음원 미리 듣기 등)
    private String audioFile;

    // 참고 동영상 (옵션: 동영상 URL)
    private String referenceVideo;

    // 추가 URL (옵션: 외부 링크 등)
    private String url;
}
