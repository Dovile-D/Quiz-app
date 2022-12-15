package com.bootcamp.quizapp.repositories;

import com.bootcamp.quizapp.models.Statistic;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface StatisticRepository extends CrudRepository<Statistic, Integer> {

    List<Statistic> getStatisticByUserId(int id);

}
