//package com.bootcamp.quizapp.mappers;
//
//import com.bootcamp.quizapp.dto.StatisticToFeDto;
//import com.bootcamp.quizapp.models.Statistic;
//import com.bootcamp.quizapp.repositories.StatisticRepository;
//import com.bootcamp.quizapp.services.StatisticService;
//import lombok.Builder;
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Component;
//
//import java.util.List;
//
//@Component
//@Builder
//@RequiredArgsConstructor
//public class StatisticToFeDtoMapper {
//
//    private final StatisticRepository statisticRepository;
//    private final StatisticService statisticService;
//
//    public List<StatisticToFeDto> convertStatisticToDtos (Statistic statistic) {
//        return StatisticToFeDto.builder()
//                .categoryName(statistic.getCategory().getCategoryName())
//                .averageScore(statisticService.getAveragecoreOfCategory(statistic, ))
//                .timesPlayed()
//                .build();
//
//    }
//
//}
