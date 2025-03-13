package com.acc_platform.service;

import com.acc_platform.mapper.MemberMapper;
import com.acc_platform.model.Member;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MemberService {

    private final MemberMapper memberMapper;

    public MemberService(MemberMapper memberMapper) {
        this.memberMapper = memberMapper;
    }

    @Transactional
    public Member registerMember(Member member) {
        // 반주자의 경우 기본 음표 등급 1, 사업자는 0 (여기서는 major에 따라 판단)
        if(member.getMajor() != null && !member.getMajor().equals("기타")) {
            member.setNoteGrade(1);
        } else {
            member.setNoteGrade(0);
        }
        memberMapper.insertMember(member);
        return member;
    }

    public Member getMemberById(Long id) {
        return memberMapper.findMemberById(id);
    }
}
