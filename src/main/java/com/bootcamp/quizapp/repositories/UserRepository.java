package com.bootcamp.quizapp.repositories;

import com.bootcamp.quizapp.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
