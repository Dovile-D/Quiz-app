package com.bootcamp.quizapp.repositories;

import com.bootcamp.quizapp.models.Category;
import com.bootcamp.quizapp.models.Statistic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface StatisticRepository extends CrudRepository<Statistic, Integer> {

    List<Statistic> getStatisticsByUserId(int id);

}
