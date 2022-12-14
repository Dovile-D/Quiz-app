package com.bootcamp.quizapp.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
public class StatisticToFeDto {
    private int userId;
    private String categoryName;
    private int averageScore;
    private int timesPlayed;
}
