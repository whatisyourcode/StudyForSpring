package com.example.firstproject.entity;

import jakarta.persistence.*;

@Entity
public class Member {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        @Column
        private String title;
        @Column
        private String content;


    public Member(){}

        public Member(Long id, String title, String content) {
            this.id = id;
            this.title = title;
            this.content = content;
        }

        @Override
        public String toString() {
            return "Member{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                '}';
        }

        public Long getId() {
            return id;
        }

}
