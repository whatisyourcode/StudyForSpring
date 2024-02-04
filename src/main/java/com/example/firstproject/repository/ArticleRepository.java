package com.example.firstproject.repository;

import com.example.firstproject.entity.Article;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

// CrudRepository는 JPA에서 제공하는 인터페이스로 이를 상송해 엔티티를 관리(생성,조회,수정,삭제)할 수 있다.
public interface ArticleRepository extends CrudRepository<Article, Long> {
    @Override
    ArrayList<Article> findAll(); // Iterable -> ArrayList 수정

}
