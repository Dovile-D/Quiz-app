package com.bootcamp.quizapp.services;

import com.bootcamp.quizapp.dto.TriviaCategoryDto;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class TriviaService {

    private RestTemplate restTemplate;

    public void RestService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public String getQuestionsInPlainJSON() {
        String url = "https://opentdb.com/api.php?amount=50&category=12&difficulty=medium";
        return this.restTemplate.getForObject(url, String.class);
    }

    public String getCategoriesInPlainJSON() {
        String url = "https://opentdb.com/api_category.php";
        return this.restTemplate.getForObject(url, String.class);
    }

    public TriviaCategoryDto[] getCategoriesAsObject() {
        String url = "https://jsonplaceholder.typicode.com/posts";
        return this.restTemplate.getForObject(url, TriviaCategoryDto[].class);
    }


    }




