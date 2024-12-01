package com.dawn.shop.common.member;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/join")
    String joinPage() {
        return "join/index";
    }

    /**
     * 회원가입
     * @param member
     * @return main page 이동
     */
    @PostMapping("/join")
    String join(@ModelAttribute Member member) {
        memberService.registerMember(member);

        return "redirect:/";
    }
}
