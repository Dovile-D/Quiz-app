package com.bootcamp.quizapp.repositories;

import com.bootcamp.quizapp.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CategoryRepository extends JpaRepository<Category, Integer> {

}
