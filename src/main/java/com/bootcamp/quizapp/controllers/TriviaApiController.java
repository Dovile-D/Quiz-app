package com.bootcamp.quizapp.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class TriviaApiController {

    @GetMapping(value = "/getCategories")
    private String getCategoriesFromApi() {
        String url = "https://the-trivia-api.com/api/categories";
        RestTemplate restTemplate= new RestTemplate();
        String result = restTemplate.getForObject(url, String.class);

        return result;
    }
}
