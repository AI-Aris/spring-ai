package com.example.spring.ai.spring.ai;

public interface ArticleRepository extends
        JpaRepository<Article, Long> {
// Custom query methods can be defined here if needed
}