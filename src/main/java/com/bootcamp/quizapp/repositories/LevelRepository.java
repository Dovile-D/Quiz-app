package com.bootcamp.quizapp.repositories;

import com.bootcamp.quizapp.models.Level;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LevelRepository extends JpaRepository<Level, Integer> {
}
