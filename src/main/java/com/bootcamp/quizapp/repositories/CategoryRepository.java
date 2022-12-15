package com.bootcamp.quizapp.repositories;

import com.bootcamp.quizapp.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;


public interface CategoryRepository extends CrudRepository<Category, Integer> {

    Category getCategoryByCategoryName(String categoryName);
    Category getCategoryById(int id);

}
