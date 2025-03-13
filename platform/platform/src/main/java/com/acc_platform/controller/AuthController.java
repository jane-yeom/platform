package com.acc_platform.controller;

import com.acc_platform.model.Member;
import com.acc_platform.service.MemberService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final MemberService memberService;

    public AuthController(MemberService memberService) {
        this.memberService = memberService;
    }

    @PostMapping("/register")
    public ResponseEntity<Member> register(@Validated @RequestBody Member member) {
        Member created = memberService.registerMember(member);
        return ResponseEntity.ok(created);
    }

    // 로그인, 중복확인 등 추가 가능
}
