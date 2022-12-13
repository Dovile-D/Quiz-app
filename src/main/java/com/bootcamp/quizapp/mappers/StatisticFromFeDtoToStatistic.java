package com.bootcamp.quizapp.mappers;

import com.bootcamp.quizapp.dto.StatisticFromFeDto;
import com.bootcamp.quizapp.models.Statistic;

public class StatisticFromFeDtoToStatistic {

    public Statistic mapStatisticDtoToStatistic(StatisticFromFeDto statisticFromFeDto) {
        Statistic statistic = Statistic.builder()
                .user(statisticFromFeDto.getUserEmail())
                .category(statisticFromFeDto.getCategoryName())
                .score(statisticFromFeDto.getScore())
                .build();
        return statistic;
    }
}
