package com.bootcamp.quizapp.repositories;

import com.bootcamp.quizapp.models.Statistic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface StatisticRepository extends CrudRepository<Statistic, Integer> {

    Statistic getStatisticByUserId(int id);
}
