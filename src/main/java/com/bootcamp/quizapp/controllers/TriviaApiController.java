package com.bootcamp.quizapp.controllers;

import com.bootcamp.quizapp.dto.TriviaCategoryDto;
import com.bootcamp.quizapp.dto.TriviaCategoryListDto;
import com.bootcamp.quizapp.mappers.TriviaCategoryDtoToCategory;
import com.bootcamp.quizapp.models.Category;
import com.bootcamp.quizapp.repositories.CategoryRepository;
import com.bootcamp.quizapp.services.CategoryService;
import com.bootcamp.quizapp.services.TriviaService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.*;
import java.util.stream.Collectors;


@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/")
@Builder
public class TriviaApiController {

    private final TriviaCategoryDtoToCategory triviaMapper;
    private final CategoryRepository categoryRepository;
    private final TriviaService triviaService;
    private final CategoryService categoryService;


    @GetMapping(value = "/getCategories")
    public String getCategories() throws JsonProcessingException {

        String url = "https://the-trivia-api.com/api/categories";
        RestTemplate restTemplate = new RestTemplate();

        List<List<TriviaCategoryDto>> primaryList = triviaService.getJsonListAsObjects(url, restTemplate);
        List<TriviaCategoryDto> triviaCategoryDtos = triviaService.getListOfTriviaCategoryDto(primaryList);

        List<Category> categories = triviaService.getCategories(triviaCategoryDtos, triviaMapper);

//        categoryService.upsertAll(categories);

        return categories.toString();

    }

    @RequestMapping(value = "/getCategories", method = RequestMethod.DELETE)
    @ResponseBody
    public String deleteAll() {
        categoryRepository.deleteAll();
        return "Successfully deleted all enitities";
    }



    @GetMapping(value = "/getQuestions")
    public String getQuestionsFromApi() {
//        String url = "https://opentdb.com/api.php?amount=50&category=12&difficulty=medium";
        String url = "https://the-trivia-api.com/api/categories";
        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(url, String.class);
        log.info("____________start__________");
        log.info(result);
        log.info("______________end_________________");

        return result;
    }


}


