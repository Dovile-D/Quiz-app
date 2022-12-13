//package com.bootcamp.quizapp.controllers;
//
//import com.bootcamp.quizapp.models.Category;
//import com.bootcamp.quizapp.models.Level;
//import com.bootcamp.quizapp.repositories.LevelRepository;
//import lombok.RequiredArgsConstructor;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.net.URI;
//import java.net.URISyntaxException;
//import java.util.List;
//
//@RestController
//@RequestMapping("/")
//@RequiredArgsConstructor
//public class LevelController {
//
//    private final LevelRepository levelRepository;
//
//    @GetMapping(value = "/levels")
//    public List<Level> getLevels() {
//        return levelRepository.findAll();
//    }
//
//    @GetMapping("/levels/{id}")
//    public Level getLevel(@PathVariable int id) {
//        return levelRepository.findById(id).orElseThrow(RuntimeException::new);
//    }
//
//    @PostMapping(value = "/levels")
//    public ResponseEntity<Level> createLevel(@RequestBody Level level) throws URISyntaxException {
//        Level savedLevel = levelRepository.save(level);
//        return ResponseEntity.created(new URI("/categories/" + savedLevel.getId())).body(savedLevel);
//    }
//
//    @PutMapping("/levels/{id}")
//    public ResponseEntity<Level> updateUser(@PathVariable int id, @RequestBody Level level) {
//        Level currentLevel = levelRepository.findById(id).orElseThrow(RuntimeException::new);
//        currentLevel.setLevelName(level.getLevelName());
//
//        return ResponseEntity.ok(currentLevel);
//    }
//}
