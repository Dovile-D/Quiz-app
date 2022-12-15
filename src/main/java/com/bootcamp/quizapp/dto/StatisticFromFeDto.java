package com.bootcamp.quizapp.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
public class StatisticFromFeDto {

    private String userName;
    private String categoryName;
    private String score;
}
