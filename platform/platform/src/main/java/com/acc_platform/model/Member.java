package com.acc_platform.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import java.time.LocalDateTime;

@Data
public class Member {
    private Long id;

    @NotBlank(message = "사용자 이름은 필수입니다.")
    private String username;

    @NotBlank(message = "이메일은 필수입니다.")
    @Email(message = "올바른 이메일 형식을 입력하세요.")
    private String email;

    @NotBlank(message = "비밀번호는 필수입니다.")
    @Size(min = 6, message = "비밀번호는 최소 6자리 이상이어야 합니다.")
    private String password;

    private String phone;

    // 전공 선택: 예) 피아노, 기타, 드럼, 바이올린, 기타(기타 항목)
    @NotBlank(message = "전공을 선택하세요.")
    private String major;

    // 역할 선택: "정규 반주자" 또는 "대타 반주자"
    @NotBlank(message = "역할을 선택하세요.")
    private String role;

    // 교육 정보
    private String highSchool;
    private String college;
    private String graduate;  // 대학원 정보

    // 초기 음표 등급 (반주자일 경우, 초기값 1, 사업자라면 0)
    private Integer noteGrade;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
