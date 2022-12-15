package com.bootcamp.quizapp.repositories;

import com.bootcamp.quizapp.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {

    Optional<User> findByEmail(String email);
    User getUserByUsername(String username);
    User getUserByEmail(String email);
    Boolean existsUserByEmail(String email);

}
