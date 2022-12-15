package com.bootcamp.quizapp.controllers;

import com.bootcamp.quizapp.dto.StatisticFromFeDto;
import com.bootcamp.quizapp.dto.StatisticToFeDto;
import com.bootcamp.quizapp.mappers.StatisticFromFeDtoToStatistic;
import com.bootcamp.quizapp.models.Category;
import com.bootcamp.quizapp.models.Statistic;
import com.bootcamp.quizapp.repositories.CategoryRepository;
import com.bootcamp.quizapp.repositories.StatisticRepository;
import com.bootcamp.quizapp.repositories.UserRepository;
import com.bootcamp.quizapp.services.StatisticService;
import com.bootcamp.quizapp.services.UserService;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;


@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping(value = "/")
public class StatisticController {

    private final StatisticService statisticService;
    private final StatisticRepository statisticRepository;
    private final StatisticFromFeDtoToStatistic statisticMapper;
    private final UserService userService;
    private final UserRepository userRepository;
    private final CategoryRepository categoryRepository;


    @GetMapping("/singleGameStatistics") // OK
    public ModelAndView getStatisticFromFe(ModelMap model, @RequestParam(name = "email", required = false) String userEmail,
                                           @RequestParam(name = "categories") String categoryName,
                                           @RequestParam(name = "score") String score) {

        ModelAndView returnPage = null;

        if (!userEmail.equals("")) {
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

            returnPage = new ModelAndView("singleGameStatistics.html", model);
        } else {
            returnPage = new ModelAndView("index.html", model);
        }
        return returnPage;
    }


    @GetMapping("/statistics")
    public ModelAndView showFullStatistics(ModelMap model, @RequestParam(name = "email") String urlEmail){

        int userId = userRepository.getUserByEmail(urlEmail).getId();
        List<Statistic> statisticListFromDB = statisticRepository.getStatisticByUserId(userId);
        List<StatisticToFeDto> dtoList = new ArrayList<>();

        if(userRepository.existsUserByEmail(urlEmail)) {
            for (Statistic entry:statisticListFromDB
                 ) {
                StatisticToFeDto dto = new StatisticToFeDto();
                dto.setCategoryName(entry.getCategory().getCategoryName());
                dto.setScore(entry.getScore());
                dtoList.add(dto);
            }
            log.info(dtoList.toString());
            model.addAttribute("dtoList", dtoList);
        }
        return new ModelAndView("user_statistics.html", "dtoList", model);
    }
}
