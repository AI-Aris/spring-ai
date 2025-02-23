package com.example.spring.ai.spring.ai;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private String content;
    // Constructors, getters and setters
    public Article() {}
    public Article(String title, String content) {
        this.title = title;
        this.content = content;
    }
// standard getters and setters
}
