package com.bootcamp.quizapp.controllers;

import com.bootcamp.quizapp.dto.StatisticFroFeDto;
import com.bootcamp.quizapp.repositories.StatisticRepository;
import com.bootcamp.quizapp.services.StatisticService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping(value = "/")
public class StatisticController {

    private final StatisticService statisticService;
    private final StatisticRepository statisticRepository;

//     http://localhost:8080/registered?name=vardas&email=vardas%40gmail.com&password=slaptazodis&avatar=bear


//    get multiple query parameters
//     http://localhost:8080/singleGameStatistics?categories=arts_and_literature&difficulty=easy&score=6&userID=&score=
    @GetMapping(name = "/singleGameStatistics")
    public StatisticFroFeDto getStatisticFromFe(@RequestParam String userEmail,
                                                                     @RequestParam String categoryName,
                                                                     @RequestParam String levelName,
                                                                     @RequestParam String score)     {


        log.info(":: email = {}, categoryName = {}, levelName = {}, score = {} ", userEmail, categoryName, levelName, score);
        return statisticService.getStatisticByUserCategoryLevelAndScore();
    }
}
