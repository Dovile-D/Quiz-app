package com.bootcamp.quizapp.repositories;

import com.bootcamp.quizapp.models.Statistic;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StatisticRepository extends JpaRepository<Statistic, Integer> {
}
