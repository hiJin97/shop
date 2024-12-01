package com.dawn.shop.common.member;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class MemberService {

    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    public Member registerMember(Member member) {
        String encodedPassword = passwordEncoder.encode(member.getPassword());

        member.setPassword(encodedPassword);

        return memberRepository.save(member);
    }

    public boolean isUsernameTaken(String userName) {
        return memberRepository.findByUserName(userName).isPresent();
    }
}
