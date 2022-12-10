package com.bootcamp.quizapp.dto;

import com.fasterxml.jackson.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class TriviaCategoryDto {
//    @JsonProperty("id")
    private String id;
//    @JsonProperty("name")
    private String name;

}
