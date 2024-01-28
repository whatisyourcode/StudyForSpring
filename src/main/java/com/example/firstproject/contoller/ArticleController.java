package com.example.firstproject.contoller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ArticleController {
    @GetMapping("/articles/new")
    public String newArticleForm() {
        return "articles/new";
    }

}
