package com.bootcamp.quizapp.controllers;

import lombok.Builder;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
@Builder
public class TriviaApiController {


    @GetMapping(value = "/getCategories")
    public String getCategoriesFromApi() {
        String url = "https://opentdb.com/api_category.php";
        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(url, String.class);
        log.info("____________start__________");
        log.info(result);
        log.info("______________end_________________");

        return result;
    }

    @GetMapping(value = "/getQuestions")
    public String getQuestionsFromApi() {
        String url = "https://opentdb.com/api.php?amount=50&category=12&difficulty=medium";
        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(url, String.class);
        log.info("____________start__________");
        log.info(result);
        log.info("______________end_________________");

        return result;
    }

}


