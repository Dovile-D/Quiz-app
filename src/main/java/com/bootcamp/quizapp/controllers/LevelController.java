package com.bootcamp.quizapp.controllers;

import com.bootcamp.quizapp.models.Level;
import com.bootcamp.quizapp.repositories.LevelRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class LevelController {

    private final LevelRepository levelRepository;

    @GetMapping(value = "/levels")
    public List<Level> getLevels() {
        return levelRepository.findAll();
    }

    @GetMapping("/levels/{id}")
    public Level getLevel(@PathVariable int id) {
        return levelRepository.findById(id).orElseThrow(RuntimeException::new);
    }

    @PutMapping("/level/{id}")
    public ResponseEntity<Level> updateUser(@PathVariable int id, @RequestBody Level level) {
        Level currentLevel = levelRepository.findById(id).orElseThrow(RuntimeException::new);
        currentLevel.setLevelName(level.getLevelName());

        return ResponseEntity.ok(currentLevel);
    }
}
