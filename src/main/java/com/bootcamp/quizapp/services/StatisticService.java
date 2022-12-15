package com.bootcamp.quizapp.services;

import com.bootcamp.quizapp.dto.StatisticToFeDto;
import com.bootcamp.quizapp.models.Category;
import com.bootcamp.quizapp.models.Statistic;
import com.bootcamp.quizapp.models.User;
import com.bootcamp.quizapp.repositories.CategoryRepository;
import com.bootcamp.quizapp.repositories.StatisticRepository;
import com.bootcamp.quizapp.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StatisticService {

    private final StatisticRepository statisticRepository;
    private final UserRepository userRepository;
    private final CategoryRepository categoryRepository;

    /**
     * Method for getting an averahe score in particular category
     *
     * @param statisticList passed list of statistic POJOs
     * @param category      category
     * @return an average score value in particular category
     */
    public int getAveragecoreOfCategory(List<Statistic> statisticList, Category category) {

        return (getAverageScoreValue(calculateTimesPlayed(category, statisticList), calculateScoreSumInCategory(category, statisticList)));

    }



    /**
     * method to sum all score values in particular category
     *
     * @param category      category
     * @param statisticList List of all entries i DB statistic table
     * @return sum of all score values in particular category
     */
    public int calculateScoreSumInCategory(Category category, List<Statistic> statisticList) {

        int finalScore = 0;
        for (Statistic statistic : statisticList) {
            if (category == statistic.getCategory()) {
                finalScore += statistic.getScore();
            }
        }
        return finalScore;
    }


    /**
     * Method to count how many entries are in DB in with particular category
     *
     * @param category      category
     * @param statisticList List of all entries i DB statistic table
     * @return counted value of entries in particular category
     */
    public int calculateTimesPlayed(Category category, List<Statistic> statisticList) {

        int count = 0;
        for (Statistic statistic : statisticList) {
            if (category == statistic.getCategory()) {
                count++;
            }
        }
        return count;
    }

    /**
     * method to get average value of scores
     *
     * @param numberOfEntries
     * @param sumOfAllScores
     * @return rounded average value of scores
     */
    public int getAverageScoreValue(int numberOfEntries, int sumOfAllScores) {
        return Math.round(sumOfAllScores / numberOfEntries);
    }


}
