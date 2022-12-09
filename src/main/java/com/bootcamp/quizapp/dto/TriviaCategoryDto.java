package com.bootcamp.quizapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;


@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class TriviaCategoryDto {

    private String id;
    private String name;

}
