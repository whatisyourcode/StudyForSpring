package com.example.firstproject.contoller;

import com.example.firstproject.dto.ArticleForm;
import com.example.firstproject.entity.Article;
import com.example.firstproject.repository.ArticleRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Controller
public class    ArticleController {
    @Autowired // 스프링 부트가 미리 생성해 놓은 리파지터리 객체 주입(DI)
    private ArticleRepository articleRepository;
    @GetMapping("/articles/new")
    public String newArticleForm() {
        return "articles/new";
    }

    @PostMapping("/articles/create")
    public String createArticle(ArticleForm form){
        log.info(form.toString());
        // System.out.println(form.toString());
        // 1. DTO를 엔티티로 변환
        Article article = form.toEntity();
        log.info(article.toString());
        // System.out.println(article.toString());
        // 2. 리파지터리로 엔티티를 DB에 저장
        Article saved = articleRepository.save(article);
        log.info(saved.toString());
        // System.out.println(saved.toString());
        return "redirect:/articles/" + saved.getId();          // redirect
    }

    @GetMapping("/articles/{id}")
    public String show(@PathVariable Long id, Model model){
        // 1.id를 조회해 DB에서 해당 데이터 가져오기
        Article articleEntity = articleRepository.findById(id).orElse(null);
        // 2. 모델에 데이터 등록하기
        model.addAttribute("article", articleEntity);
        // 3.뷰 페이지 반환하기
        return "articles/show";
    }

    @GetMapping("/articles")
    public String index(Model model){
        // findAll() 반환 타입은 Iterable 이다. 해결 방법은
        // 1.Iterable 을 List<Article>로 다운캐스팅.
        // 2.List<Article>을 Iterable 타입으로 맞추기.
        // 3.ArrayList 이용. -> ArticleRepository에서 findAll() 반환 타입을 ArrayList<> 로 바꾸어 오버라이딩.
        // 1. 모든 데이터 가져오기
        List<Article> articleEntityList = articleRepository.findAll();
        // 2. 모델에 데이터 등록하기
        model.addAttribute("articleList", articleEntityList);
        // 3. 뷰 페이지 설정하기
        return "articles/index";
    }

    @GetMapping("/articles/{id}/edit")
    public String edit(@PathVariable Long id,Model model){ // id를 매개변수로 가져오기
        // 수정할 데이터 가져오기
        Article articleEntity = articleRepository.findById(id).orElse(null);
        // 모델에 데이터 등록하기
        model.addAttribute("article",articleEntity);
        // 뷰 페이지 설정하기
        return "articles/edit";
    }

    @PostMapping("/articles/update")
    public String update(ArticleForm form){ // ArticleForm의 id를 추가
        log.info(form.toString());
        // 1. DTO를 엔티티로 변환하기
        Article articleEntity = form.toEntity();
        log.info(articleEntity.toString());
        // 2. 엔티티를 DB에 저장하기
        // 2-1. DB에서 기존 데이터 가져오기
        Article target = articleRepository.findById(articleEntity.getId()).orElse(null);
        // 2-2. 기존 데이터 값을 갱신하기
        if(target != null){
            articleRepository.save(articleEntity);
        }
        // 3. 수정 결과 페이지로 리다이렉드하기
        return "redirect:/articles/"+articleEntity.getId();
    }

    @GetMapping("/articles/{id}/delete")
    public String delete(@PathVariable Long id, RedirectAttributes rttr){
        log.info("삭제 요청이 들어왔습니다.");
        // 1. 삭제할 대상 가져오기
        Article target = articleRepository.findById(id).orElse(null);
        // 2. 대상 엔티티 삭제하기
        if(target != null){
            articleRepository.delete(target);
            rttr.addFlashAttribute("msg","삭제했습니다");
        }
        // 3. 리다이렉트로 결과 페이지 반환하기
        return "redirect:/articles";
    }
}


