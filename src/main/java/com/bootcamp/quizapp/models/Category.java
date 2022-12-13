package com.bootcamp.quizapp.models;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Builder
@Entity
@Data
@RequiredArgsConstructor
@AllArgsConstructor
@Table(name = "quiz_category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "category_name")
    private String categoryName;
//    @OneToMany(targetEntity = Statistic.class, cascade = CascadeType.ALL)
//    @JoinColumn(name = "category_FK", referencedColumnName = "id")
//    private List <Statistic> statisticList;
}
