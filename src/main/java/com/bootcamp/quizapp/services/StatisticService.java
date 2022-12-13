package com.bootcamp.quizapp.services;

import com.bootcamp.quizapp.dto.StatisticFromFeDto;
import com.bootcamp.quizapp.models.Statistic;
import com.bootcamp.quizapp.repositories.StatisticRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StatisticService {

    private final StatisticRepository statisticRepository;

    public StatisticFromFeDto getStatisticByUserCategoryAndScore() {
        return null;
    }

    public StatisticFromFeDto setStatisticEntry(){
        return null;
    }

    public int getAverageStatisticValue(int score) {

        return score / 20;

    }

    public List<Statistic> groupValuesByCategory() {
        return null;
    }

    public


}
