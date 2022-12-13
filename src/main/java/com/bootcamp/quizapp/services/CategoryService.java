package com.bootcamp.quizapp.services;

import com.bootcamp.quizapp.models.Category;
import com.bootcamp.quizapp.repositories.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;


//    public void upsertAll(List<Category> categories) {
//        for(Category category: categories) {
//            if(!category.getTriviaId().equalsIgnoreCase(categoryRepository.findCategoryByTriviaId(category.getTriviaId()))) {
//                categoryRepository.save(category);
//            }
//        }
//    }
}
