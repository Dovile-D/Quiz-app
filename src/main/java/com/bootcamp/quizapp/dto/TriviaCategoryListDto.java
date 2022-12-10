package com.bootcamp.quizapp.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Data
@RequiredArgsConstructor
@AllArgsConstructor

public class TriviaCategoryListDto {
    private List<TriviaCategoryDto> triviaCategories;
}
