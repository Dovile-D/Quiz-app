package com.bootcamp.quizapp.controllers;

import com.bootcamp.quizapp.dto.StatisticFromFeDto;
import com.bootcamp.quizapp.mappers.StatisticFromFeDtoToStatistic;
import com.bootcamp.quizapp.models.Statistic;
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
    private final StatisticFromFeDtoToStatistic statisticMapper;

//     http://localhost:8080/registered?name=vardas&email=vardas%40gmail.com&password=slaptazodis&avatar=bear


//    get multiple query parameters
//     http://localhost:8080/singleGameStatistics?categories=arts_and_literature&difficulty=easy&score=6&userID=&score=
    @GetMapping(name = "/singleGameStatistics")
    public StatisticFromFeDto getStatisticFromFe(@RequestParam String userEmail,
                                                 @RequestParam String categoryName,
                                                 @RequestParam String score)     {

//        building Statistic object from received params
       StatisticFromFeDto statisticEntry = StatisticFromFeDto.builder()
               .userEmail(userEmail)
               .categoryName(categoryName)
               .score(score)
               .build();

        log.info(":: email = {}, categoryName = {}, score = {} ", userEmail, categoryName, score);

//        mapping dto to entity:
        Statistic mappedEntry = statisticMapper.mapStatisticDtoToStatistic(statisticEntry);
        log.info(":: mapped Statistic {}", mappedEntry.toString());

//        saving entity to DB:
        statisticRepository.save(mappedEntry);

        return statisticEntry;
    }
}
