package com.dawn.shop;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

@Controller
public class BasicController {
    @GetMapping("/")
    String hello() {
        return "index";
    }

    @GetMapping("/about")
    @ResponseBody
    String about() {
        return "소개합니다";
    }

    @GetMapping("/date")
    @ResponseBody
    String getDate() {
        LocalDateTime now = LocalDateTime.now();

        String formattedNow = now.format(DateTimeFormatter.ofPattern("yyyy년 MM월 dd일 HH시 mm분 ss초"));

        return formattedNow;
//        return ZonedDateTime.now().toString();
    }
}
