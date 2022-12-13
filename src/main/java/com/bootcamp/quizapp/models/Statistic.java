package com.bootcamp.quizapp.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Entity
@Data
@RequiredArgsConstructor
@AllArgsConstructor
@Table(name = "statistic")
public class Statistic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "score")
    private int score;
    //changed from timestamp to these:
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
    @JoinColumn(name = "difficulty_id")
    @ManyToOne
    private Level difficulty;
    @JoinColumn(name = "user_id")
    @ManyToOne
    private User user;

}
