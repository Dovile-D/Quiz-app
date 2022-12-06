package com.bootcamp.quizapp.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

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
    @Column(name = "score_time")
    private LocalDateTime scoreTime;
    @ManyToOne
//    @JoinColumn(name = "user_ids")
    private User user;
    @ManyToOne
//    @JoinColumn(name = "category_id")
    private Category category;
    @ManyToOne
//    @JoinColumn(name = "level_id")
    private Level level;

}
