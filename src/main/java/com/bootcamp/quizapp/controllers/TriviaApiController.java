package com.bootcamp.quizapp.controllers;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.apache.coyote.Response;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class TriviaApiController {

    @GetMapping(value = "/getCategories")
    public String getCategoriesFromApi(String... args) throws Exception{
//        String url = "https://the-trivia-api.com/api/categories";
        String url = "https://opentdb.com/api_category.php";
        RestTemplate restTemplate= new RestTemplate();
        String result = restTemplate.getForObject(url, String.class);
//        Response response = restTemplate.getForObject(url, Response.class);
        log.info("____________start__________");
        log.info(result);
        log.info("______________end_________________");

//        System.out.println(result);
//
////
//        List<String> results = List.of((result.replace(":", "")
//                .replace("[", "")
//                .replace("]", "")
//                .replace(",", "")
//                .replace("{", "")
//                .replace("}", "")
//                .split("\"")));
//
//        System.out.println(results.stream().toList());
//
//        List<String> correctCategories = new ArrayList<>();

//        for(int i = 0; i < results.size(); i++) {
//            System.out.println(i);
//            System.out.println(correctCategories.get(i));
//            i++;
//        }




        return result;
    }
}
