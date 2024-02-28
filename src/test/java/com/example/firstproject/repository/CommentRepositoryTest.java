package com.example.firstproject.repository;

import com.example.firstproject.entity.Article;
import com.example.firstproject.entity.Comment;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@DataJpaTest
class CommentRepositoryTest {
    @Autowired
    CommentRepository commentRepository;

    @Test
    @DisplayName("특정 게시글의 모든 댓글 조회")
    /* Case 1 : 4번 게시글의 모든 댓글 조회 */
    void findByArticleId() {
        {
            // 1. 입력 데이터 준비
            Long articleId = 4L;
            // 2. 실제 데이터
            List<Comment> comments = commentRepository.findByArticleId(articleId);
            // 3. 예상 데이터
            Article article = new Article(4L, "당신의 인생 영화는?", "댓글 고");
            Comment a = new Comment(1L, article, "Park", "굿 윌 헌팅");
            Comment b = new Comment(2L, article, "Kim", "타짜");
            Comment c = new Comment(3L, article, "Choi", "쇼생크 탈출");
            List<Comment> expected = Arrays.asList(a, b, c);
            // 4. 비교 및 검증
            assertEquals(expected.toString(), comments.toString(), "4번글의 모든 댓글을 출력!"); // 검증 실패시 메세지
        }
        /* Case 2 : 1번 게시글의 모든 댓글 조회 */
        {
            // 1. 입력 데이터 준비
            Long articleId = 1L;
            // 2. 실제 데이터
            List<Comment> comments = commentRepository.findByArticleId(articleId);
            // 3. 예상 데이터
            Article article = new Article(1L, "가가가가","1111");
            List<Comment> expected = Arrays.asList(); // 댓글이 없기 때문에 asList()에 아무것도 들어가지 않는다.
            // 4. 비교 및 검증
            assertEquals(expected.toString(), comments.toString(),"1번 글은 댓글이 없음"); // 검증 실패시 메세지
        }
        /* Case 4: 9번 게시글의 모든 댓글 조회 */
        {
            // 1. 입력 데이터 준비
            Long articleId = 9L;
            // 2. 실제 데이터
            List<Comment> comments = commentRepository.findByArticleId(articleId);
            // 3. 예상 데이터
            Article article = null;
            List<Comment> expected = Arrays.asList();
            // 4. 비교 및 검증
            assertEquals(expected.toString(), comments.toString(), "9번 글 자체가 없으므로 댓글은 비어있어야 함.");
        }
    }
    @Test
    @DisplayName("특정 닉네의 모든 댓글 조회")
    void findByNickName() {
        /* Case 1: "Park"의 모든 댓글 조회*/
        {
            // 1. 입력 데이터 준비
            String nickname = "Park";
            // 2. 실제 데이터
            List<Comment> comments = commentRepository.findByNickName(nickname);
            // 3. 예상 데이터
            Comment a = new Comment(1L, new Article(4L,"당신의 인생 영화는?","댓글 고"),nickname,"굿 윌 헌팅");
            Comment b = new Comment(4L, new Article(5L,"당신의 소울푸드는?","댓글 고고"),nickname,"치킨");
            Comment c = new Comment(7L, new Article(6L,"당신의 취미는?","댓글 고고고"),nickname,"조깅");
            List<Comment> expected = Arrays.asList(a,b,c);
            // 4. 비교 및 검증
            assertEquals(expected.toString(),comments.toString(),"Park의 모든 댓글을 출력!");
        }
    }


}