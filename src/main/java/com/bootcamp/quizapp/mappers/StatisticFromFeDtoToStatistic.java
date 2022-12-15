package com.bootcamp.quizapp.mappers;

import com.bootcamp.quizapp.dto.StatisticFromFeDto;
import com.bootcamp.quizapp.models.Statistic;
import com.bootcamp.quizapp.repositories.CategoryRepository;
import com.bootcamp.quizapp.repositories.UserRepository;
import com.bootcamp.quizapp.services.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class StatisticFromFeDtoToStatistic {

    private final UserRepository userRepository;
    private final CategoryRepository categoryRepository;
    private final CategoryService categoryService;

    public Statistic mapStatisticDtoToStatistic(StatisticFromFeDto statisticFromFeDto) {
        String properCategoryName = categoryService.getProperCategoryName(statisticFromFeDto.getCategoryName());

        Statistic statistic = Statistic.builder()
                .user(userRepository.getUserByUsername(statisticFromFeDto.getUserName()))
                .category(categoryRepository.getCategoryByCategoryName(properCategoryName))
                .score(Integer.parseInt(statisticFromFeDto.getScore()))
                .build();
        return statistic;
    }
}
