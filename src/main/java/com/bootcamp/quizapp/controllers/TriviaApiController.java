package com.bootcamp.quizapp.controllers;

import com.bootcamp.quizapp.dto.TriviaCategoryDto;
import com.bootcamp.quizapp.dto.TriviaCategoryListDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/")
@Builder
public class TriviaApiController {


//    @GetMapping(value = "/getCategories")
//    public String getCategoriesFromApi() throws JsonProcessingException {
//        String url = "https://opentdb.com/api_category.php";
//        RestTemplate restTemplate = new RestTemplate();
//        String result = restTemplate.getForObject(url, String.class);
//        log.info("____________start__________");
//        log.info(result);
//        log.info("______________end_________________");
//
//
//        log.info("before creating bjectMapper instance");
//        ObjectMapper om = new ObjectMapper();
//        log.info("before adding to List");
//        TriviaCategoryListDto triviaCategoryList = om.readValue(result, TriviaCategoryListDto.class);
//
//        log.info("before printing");
//
//        log.info(triviaCategoryList.toString());
//
////        String loudScreaming = result.getJSONObject("LabelData").getString("slogan");
//
//        return result;
//    }

    @GetMapping(value = "/getCategories")
    public String getCat() throws JsonProcessingException {
        RestTemplate restTemplate = new RestTemplate();
        String fooResourceUrl = "https://opentdb.com/api_category.php";

        ResponseEntity<Object> foo = restTemplate.getForEntity(fooResourceUrl, Object.class);
        Object objects = foo.getBody();
        ObjectMapper mapper = new ObjectMapper();

        List<List<TriviaCategoryDto>> list = Arrays.stream(new Object[]{objects})
                .map(object -> mapper.convertValue(object, TriviaCategoryListDto.class))
                .map(TriviaCategoryListDto::getTrivia_categories)
                .collect(Collectors.toList());
        log.info("______checking____" + foo.getBody());

//        list.forEach(o -> System.out.println(o.toString()));
//        List<List <TriviaCategoryDto>> fullList = new ArrayList<>();
//        fullList = list.stream().collect(Collectors.toList());
//        fullList.forEach(System.out::println);




        ResponseEntity<String> response
                = restTemplate.getForEntity(fooResourceUrl + "/1", String.class);
        log.info("String value: " + response.getBody());


        return response.getBody();
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


