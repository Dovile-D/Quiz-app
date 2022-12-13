package com.bootcamp.quizapp.services;

import com.bootcamp.quizapp.dto.TriviaCategoryDto;
import com.bootcamp.quizapp.dto.TriviaCategoryListDto;
import com.bootcamp.quizapp.mappers.TriviaCategoryDtoToCategory;
import com.bootcamp.quizapp.models.Category;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TriviaService {


    public List<List<TriviaCategoryDto>> getJsonListAsObjects(String url, RestTemplate restTemplate) {
        ResponseEntity<Object> responseObject = restTemplate.getForEntity(url, Object.class);
        Object objects = responseObject.getBody();
        ObjectMapper mapper = new ObjectMapper();

        return Arrays.stream(new Object[]{objects})
                .map(object -> mapper.convertValue(object, TriviaCategoryListDto.class))
                .map(TriviaCategoryListDto::getTrivia_categories)
                .collect(Collectors.toList());

    }


    public List<TriviaCategoryDto> getListOfTriviaCategoryDto(List<List<TriviaCategoryDto>> list) {

        List<TriviaCategoryDto> triviaCategoryDtos = new ArrayList<>();
        List<List<TriviaCategoryDto>> fullList = list.stream().collect(Collectors.toList());

        for (List<TriviaCategoryDto> tcd : list
        ) {
            triviaCategoryDtos.addAll(tcd);

        }

        return triviaCategoryDtos;
    }


    public List<Category> getCategories (List<TriviaCategoryDto> triviaCategoryDtos, TriviaCategoryDtoToCategory triviaMapper) {

        return triviaCategoryDtos.stream()
                .map(triviaMapper::convertCategoryDtoToCategoryEntity)
                .collect(Collectors.toList());

    }

}




