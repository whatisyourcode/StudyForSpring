package com.example.firstproject.dto;

import com.example.firstproject.entity.Member;

public class MemberForm {
    private String email;
    private String content;

    public MemberForm(String email, String content) {
        this.email = email;
        this.content = content;
    }

    @Override
    public String toString() {
        return "MemberForm{" +
                "email='" + email + '\'' +
                ", content='" + content + '\'' +
                '}';
    }

    public Member toEntity(){
        return new Member(null, email, content);
    }
}
