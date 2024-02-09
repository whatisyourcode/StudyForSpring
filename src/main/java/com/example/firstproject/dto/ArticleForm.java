package com.example.firstproject.dto;


import com.example.firstproject.entity.Article;
import lombok.AllArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@ToString
public class ArticleForm {
    private Long id;            // 수정하는 부분에서 추가되었음.
    private String title;
    private String content;


    public Article toEntity() {
        return new Article(id, title,content);
    }
}
