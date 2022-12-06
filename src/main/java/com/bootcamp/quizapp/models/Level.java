package com.bootcamp.quizapp.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Entity
@Data
@RequiredArgsConstructor
@AllArgsConstructor
@Table(name = "difficulty_level")
public class Level {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "level_name")
    private String levelName;
    @OneToMany(targetEntity = Statistic.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "level_FK", referencedColumnName = "id")
    private List<Statistic> statisticList;
}
