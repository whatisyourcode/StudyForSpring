package com.example.firstproject.dto;

import com.example.firstproject.entity.Member;
import lombok.AllArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@ToString
public class MemberForm {
    private Long id;
    private String email;
    private String content;

    /*
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

     */

    public Member toEntity(){
        return new Member(id, email, content);
    }
}
