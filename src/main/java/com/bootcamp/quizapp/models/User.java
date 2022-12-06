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
@Table(name="Users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;
    @Column(name="name")
    private String name;
    @Column(name = "email")
    private String email;
    @OneToMany(targetEntity = Statistic.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "statistic_FK", referencedColumnName = "id")
    private List<Statistic> statisticList;

}
