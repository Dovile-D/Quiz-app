package com.bootcamp.quizapp.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.util.List;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
@ToString
public class TriviaCategoryListDto {
    private List<TriviaCategoryDto> trivia_categories;
}
