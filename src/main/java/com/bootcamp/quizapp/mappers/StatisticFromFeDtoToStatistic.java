package com.bootcamp.quizapp.mappers;

import com.bootcamp.quizapp.dto.StatisticFromFeDto;
import com.bootcamp.quizapp.models.Statistic;
import com.bootcamp.quizapp.repositories.CategoryRepository;
import com.bootcamp.quizapp.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class StatisticFromFeDtoToStatistic {

    private final UserRepository userRepository;
    private final CategoryRepository categoryRepository;

    public Statistic mapStatisticDtoToStatistic(StatisticFromFeDto statisticFromFeDto) {
        Statistic statistic = Statistic.builder()
                .user(userRepository.getUserByEmail(statisticFromFeDto.getUserEmail()))
                .category(categoryRepository.getCategoryByCategoryName(statisticFromFeDto.getCategoryName()))
                .score(Integer.parseInt(statisticFromFeDto.getScore()))
                .build();
        return statistic;
    }
}
