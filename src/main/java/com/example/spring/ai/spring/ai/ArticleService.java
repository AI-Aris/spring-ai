package com.example.spring.ai.spring.ai;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class ArticleService {
    @Autowired
    private ArticleRepository articleRepository;
    @Autowired
    private ChatGptService chatGptService;
    public Article generateAndSaveArticle(String seedText) {
        String generatedContent = chatGptService.
                generateText(seedText);
        String generatedTitle = "Generated Title: " + seedText.
                substring(0, Math.min(10, seedText.length())) + "...";
        Article article = new Article(generatedTitle,
                generatedContent);
        return articleRepository.save(article);
    }
    public List<Article> getAllArticles() {
        return articleRepository.findAll();
    }
}