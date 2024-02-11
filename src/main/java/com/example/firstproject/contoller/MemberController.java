package com.example.firstproject.contoller;

import com.example.firstproject.dto.ArticleForm;
import com.example.firstproject.dto.MemberForm;
import com.example.firstproject.entity.Article;
import com.example.firstproject.entity.Member;
import com.example.firstproject.repository.MemberRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Slf4j
    @Controller
public class MemberController {
    @Autowired
    private MemberRepository memberRepository;

    @GetMapping("/signup")
    public String singUp(){
        return "members/new";
    }

    @PostMapping("/join")
    public String joinMember(MemberForm memberForm){
        // System.out.println(memberForm.toString());
        log.info(memberForm.toString());
        // 1. DTO를 엔티티로 변환
        Member member = memberForm.toEntity();
        log.info(member.toString());
        // System.out.println(member.toString());
        // 2. 리파지토리를 이용하여 엔티티를 DB에 저장.
        Member saved = memberRepository.save(member);
        log.info(saved.toString());
        //System.out.println(saved.toString());
        return "redirect:/members/"+saved.getId();
    }

    @GetMapping("/members/{id}")
    public String show(@PathVariable Long id, Model model){
        // 1.id를 조회하여 DB에서 해당 데이터 가져오기
        Member member = memberRepository.findById(id).orElse(null);
        // 2. 모델에 데이터 등록하기
        model.addAttribute("member", member);
        // 3. 뷰 페이지 반환하기
        return "members/show";
    }

    @GetMapping("/members")
    public String index(Model model){
        // 1. 모든 데이터 가져오기
        List<Member> memberEntityList = memberRepository.findAll();
        // 2. 모델에 데이터 등록하기
        model.addAttribute("memberList", memberEntityList);
        // 3. 뷰페이지에 전달하기
        return "members/index";
    }

    @GetMapping("/members/{id}/edit")
    public String edit(@PathVariable Long id,  Model model){
        // 1.  데이터 가져오기
        Member memberEntity = memberRepository.findById(id).orElse(null);
        // 2. 모델 사용/해서 데이터를 전달하기
        model.addAttribute("member",memberEntity);
        // 3. 뷰에 사용자에게 보여주기
        return "members/edit";
    }

    @PostMapping("/members/update")
    public String update(MemberForm form){
        // 1. DTO를 엔티티로 변환하기
        Member memberEntity = form.toEntity();
        // 2. 엔티티를 DB에 저장하기
        // 2-1. DB에 기존 데이터 가져오기
        Member target = memberRepository.findById(memberEntity.getId()).orElse(null);
        // 2-2. 기존 데이터 값을 갱신하기
        if(target != null){ // 기존에 있는 값이 null이 아닌지 검사
            memberRepository.save(memberEntity);
        }
        // 3.수정 결과 페이지로 리다이렉트하기
        return "redirect:/members/"+memberEntity.getId();
    }
}



















