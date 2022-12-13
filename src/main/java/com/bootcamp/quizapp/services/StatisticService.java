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

  public int getAverageScore(List<Statistic> statisticList, int userId) {


  }

}
