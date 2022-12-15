package com.bootcamp.quizapp.services;

import com.bootcamp.quizapp.models.Category;
import com.bootcamp.quizapp.repositories.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService {

//    method to convert category name values from url to values in DB
    public String getProperCategoryName(String nameFromUrl) {

        String convertedName = StringUtils.capitalize(nameFromUrl).replace("_", " ");

        return convertedName;
    }


}
