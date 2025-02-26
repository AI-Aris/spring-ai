package com.example.spring.ai.spring.ai;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
@Service
public class ChatGptService {
    @Autowired
    private RestTemplate restTemplate;
    @Value("${chatgpt.api.url}")
    private String apiUrl;
    @Value("${chatgpt.api.key}")
    private String apiKey;
    public String generateText(String prompt) {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + apiKey);
        HttpEntity<String> entity = new HttpEntity<>(prompt,
                headers);
        ResponseEntity<String> response = restTemplate.
                exchange(apiUrl, HttpMethod.POST, entity, String.class);
        return response.getBody();
    }
}