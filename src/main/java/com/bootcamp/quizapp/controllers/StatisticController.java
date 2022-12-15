package com.bootcamp.quizapp.controllers;

import com.bootcamp.quizapp.dto.StatisticFromFeDto;
import com.bootcamp.quizapp.dto.StatisticToFeDto;
import com.bootcamp.quizapp.mappers.StatisticFromFeDtoToStatistic;
import com.bootcamp.quizapp.models.Statistic;
import com.bootcamp.quizapp.repositories.StatisticRepository;
import com.bootcamp.quizapp.services.StatisticService;
import com.bootcamp.quizapp.services.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping(value = "/")
public class StatisticController {

    private final StatisticService statisticService;
    private final StatisticRepository statisticRepository;
    private final StatisticFromFeDtoToStatistic statisticMapper;
    private final UserService userService;


    @GetMapping("/singleGameStatistics") // OK
    public ModelAndView getStatisticFromFe(ModelMap model, @RequestParam(name = "user", required = false) String userName,
                                           @RequestParam(name = "categories") String categoryName,
                                           @RequestParam(name = "score") String score) {

        ModelAndView returnPage = null;

        if (!userName.equals("")) {
            //        building Statistic object from received params
            StatisticFromFeDto statisticEntry = StatisticFromFeDto.builder()
                    .userName(userName)
                    .categoryName(categoryName)
                    .score(score)
                    .build();

            log.info(":: email = {}, categoryName = {}, score = {} ", userName, categoryName, score);

//        mapping dto to entity:
            Statistic mappedEntry = statisticMapper.mapStatisticDtoToStatistic(statisticEntry);
            log.info(":: mapped Statistic {}", mappedEntry.toString());

//        saving entity to DB:
            statisticRepository.save(mappedEntry);

            returnPage = new ModelAndView("user_option.html", model);
        } else {
            returnPage = new ModelAndView("index.html", model);
        }

        return returnPage;

    }

}
