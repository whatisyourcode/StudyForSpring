package com.example.firstproject.service;

import com.example.firstproject.dto.CommentDto;
import com.example.firstproject.entity.Article;
import com.example.firstproject.entity.Comment;
import com.example.firstproject.repository.ArticleRepository;
import com.example.firstproject.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CommentService {
    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    private ArticleRepository articleRepository;

    public List<CommentDto> comments(Long articleId) {
/*        // 1. 댓글 조회
        List<Comment> comments = commentRepository.findByArticleId(articleId);
        // 2. 엔티티 -> DTO 변환
        List<CommentDto> dtos = new ArrayList<CommentDto>();
        for(int i=0; i<comments.size(); i++){
            Comment c = comments.get(i);
            CommentDto dto = CommentDto.createCommentDto(c); // comment Entity를 commentDto로 변환.
            dtos.add(dto);
        }*/

        // 3. 결과 반환
        return commentRepository.findByArticleId(articleId)
                .stream().map(comment -> CommentDto.createCommentDto(comment))
                .collect(Collectors.toList());
    }
    // create는 DB내용을 바꾸기 때문에 실패할 경우를 대비해야한다.트랜잭션 사용.
    @Transactional
    public CommentDto create(Long articleId,CommentDto dto){
        // 1. 게시글 조회 및 예외 발생
        Article article = articleRepository.findById(articleId)
                .orElseThrow(() -> new IllegalArgumentException("댓글 생성 실패! " + "대상 게시글이 없습니다"));
        // 2. 댓글 엔티티 생성
        Comment comment = Comment.createComment(dto,article);
        // 3. 댓글 엔티티를 DB에 저장
        Comment created = commentRepository.save(comment);
        // 4. DTO로 변환해 반환
        return CommentDto.createCommentDto(created);
    }
}
