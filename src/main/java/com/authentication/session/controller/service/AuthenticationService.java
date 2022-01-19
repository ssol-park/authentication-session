package com.authentication.session.controller.service;

import com.authentication.session.controller.dto.LoginInfo;
import com.authentication.session.controller.model.Member;
import com.authentication.session.controller.repository.MemberRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AuthenticationService {

    private final MemberRepository memberRepo;

    public AuthenticationService(MemberRepository memberRepo) {
        this.memberRepo = memberRepo;
    }

    @Transactional
    public Member login(LoginInfo loginInfo) {
        Member member = memberRepo.findByEmail(loginInfo.getEmail()).orElse(null);

        if(member == null) return null;

        if(!member.getPassword().equals(loginInfo.getPassword())) return null;

        return member;
    }

}
