package com.bootcamp.quizapp.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
public class StatisticFroFeDto {

    private String userEmail;
    private String categoryName;
    private String levelName;
}
