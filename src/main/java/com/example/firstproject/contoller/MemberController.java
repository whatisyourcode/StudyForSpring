package com.example.firstproject.contoller;

import com.example.firstproject.dto.MemberForm;
import com.example.firstproject.entity.Member;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MemberController {

    @GetMapping("/signup")
    public String singUp(){
        return "members/new";
    }

    @PostMapping("/join")
    public String joinMember(MemberForm memberForm){
        // System.out.println(memberForm.toString());
        // 1. DTO를 엔티티로 변환
        Member member = memberForm.toEntity();
        // 2. 리파지토리를 이용하여 엔티티를 DB에 저장.
        return "";
    }
}
