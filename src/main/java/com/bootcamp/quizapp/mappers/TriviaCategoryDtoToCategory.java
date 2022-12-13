package com.bootcamp.quizapp.mappers;

import com.bootcamp.quizapp.dto.TriviaCategoryDto;
import com.bootcamp.quizapp.models.Category;
import org.springframework.stereotype.Component;

@Component
public class TriviaCategoryDtoToCategory {

    public Category convertCategoryDtoToCategoryEntity(TriviaCategoryDto triviaCategoryDto) {
        Category category = Category.builder()
                .categoryName(triviaCategoryDto.getName())
//                .triviaId(triviaCategoryDto.getId())
                .build();
        return category;
    }
}
