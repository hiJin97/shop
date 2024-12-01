package com.dawn.shop.common.member;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/member")
@RequiredArgsConstructor
public class MemberRestController {

    private final MemberService memberService;

    @GetMapping("/check-username")
    public boolean checkUserName(@RequestParam("userName") String userName) {
        return !memberService.isUsernameTaken(userName);
    }
}
