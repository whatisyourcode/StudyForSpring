package com.example.firstproject.api;

import com.example.firstproject.dto.MemberForm;
import com.example.firstproject.entity.Member;
import com.example.firstproject.repository.MemberRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
public class MemberApiController {
    @Autowired
    private MemberRepository memberRepository;
    // GET
    @GetMapping("/api/members")
    public List<Member> index(){
        return memberRepository.findAll();
    }
    @GetMapping("/api/members/{id}")
    public Member show(@PathVariable Long id){
        return memberRepository.findById(id).orElse(null);
    }
    // POST
    @PostMapping("/api/members")
    public Member create(@RequestBody MemberForm dto){
        Member member = dto.toEntity();
        log.info("check : {}",member.toString());
        return memberRepository.save(member);
    }
    // PATCH
    @PatchMapping("/api/members/{id}")
    public ResponseEntity<Member> update(@PathVariable Long id,@RequestBody MemberForm dto){
        // 1.엔티티 -> dto로 변환
        Member member = dto.toEntity();
        // 2.타깃 조회
        Member target = memberRepository.findById(id).orElse(null);
        // 3.잘못된 요청 처리
        if(target == null || id != member.getId()){
            log.info("잘못된 요청! id : {} , member : {}",id,member.toString());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
        // 4.업데이트 및 정상(200) 응답 처리
        Member updated = memberRepository.save(member);
        return ResponseEntity.status(HttpStatus.OK).body(updated);
    }
    @DeleteMapping("/api/members/{id}")
    public ResponseEntity<Member> delete(@PathVariable Long id){
        // 1.엔티티가 있는지 조회
        Member target = memberRepository.findById(id).orElse(null);
        // 2.대상 엔티티가 없어서 요청이 잘못된 경우 처리
        if(target == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
        // 3.대상 엔티티 삭제 + 정상(200) 응답 처리.
        memberRepository.delete(target);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

}
