package com.example.firstproject.api;

import com.example.firstproject.dto.ArticleForm;
import com.example.firstproject.entity.Article;
import com.example.firstproject.repository.ArticleRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
public class ArticleApiController {
    @Autowired
    private ArticleRepository articleRepository;
    // GET
    @GetMapping("/api/articles")
    public List<Article> index(){
        return articleRepository.findAll();
    }
    @GetMapping("/api/articles/{id}")
    public Article show(@PathVariable Long id){
        return articleRepository.findById(id).orElse(null);
    }
    // POST
    @PostMapping("/api/artcles")
    public Article create(@RequestBody ArticleForm dto){
        Article article = dto.toEntity();
        return articleRepository.save(article);
    }
    // PATCH
    @PatchMapping("/api/articles/{id}")
    public ResponseEntity<Article> update(@PathVariable Long id, @RequestBody ArticleForm dto){
        // 1. DTO --> 엔티티 변환하기
        Article article = dto.toEntity();
        log.info("id : {}, article: {}", id, article.toString());
        // 2. 타깃 조회하기
        Article target = articleRepository.findById(id).orElse(null);
        // 3. 잘못된 요청 처리하기
        if (target == null || id != article.getId()) {
            // 400 , 잘못된 요청 응답
            log.info("잘못된 요청! id: {}, article: {}",id,article.toString());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
        // 4. 업데이트 및 정상 응답(200)하기
        target.patch(article);
        Article updated = articleRepository.save(target); // 데이터베이스에 target을 저장하고 ㅈ
        return ResponseEntity.status(HttpStatus.OK).body(updated);
    }
    // DELETE
    @DeleteMapping("/api/articles/{id}")
    public ResponseEntity<Article> delete(@PathVariable Long id) {
        // 1. DB에서 대상 엔티티가 있는지 조회하기
        Article target = articleRepository.findById(id).orElse(null);
        // 2. 대상 엔티티가 없어서 요청 자체가 잘못됐을 경우 처리하기
        if (target == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
        // 3. 대상 엔티티가 있으면 삭제하고 정상 응답(200) 반환하기.
        articleRepository.delete(target);
        return ResponseEntity.status(HttpStatus.OK).build(); // build()는 HTTP 응답의 body가 없는 ResponseEntity 객체 생성
        // ResponseEntity.status(HttpStatus.OK)는 HTTP 상태가 OK(200)인 ResponseEntity 객체를 생성하고, 이어서 .build() 메서드를 호출하여 완전한 상태(body가 없는)로 만든 후 반환하는 과정입니다.
    }
}