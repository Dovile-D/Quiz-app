package com.bootcamp.quizapp.controllers;

import com.bootcamp.quizapp.models.Category;
import com.bootcamp.quizapp.repositories.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;

@RestController
@RequestMapping("/")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryRepository categoryRepository;

    @GetMapping(value = "/categories/{id}")
     public Category getCategory(@PathVariable int id) {
        return categoryRepository.findById(id).orElseThrow(RuntimeException::new);
    }

    @PostMapping(value = "/categories")
    public ResponseEntity<Category> createCategory(@RequestBody Category category) throws URISyntaxException {
        Category savedCategory = categoryRepository.save(category);
        return ResponseEntity.created(new URI("/categories/" + savedCategory.getId())).body(savedCategory);
    }


    @PutMapping(value = "/categories/{id}")
    public ResponseEntity<Category> updateUser(@PathVariable int id, @RequestBody Category category) {
        Category currentCategory = categoryRepository.findById(id).orElseThrow(RuntimeException::new);
        currentCategory.setCategoryName(category.getCategoryName());

        return ResponseEntity.ok(currentCategory);

    }

}

