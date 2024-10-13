package com.ailson.taskflow.controller;

import com.ailson.taskflow.request.BoardRequest;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("board")
public class BoardController {

    @GetMapping
    public String get() {
        return "quadros x";
    }

    @PostMapping
    public void create(@Valid @RequestBody BoardRequest request) {
        System.out.println("title: " + request.getTitle());
    }
}
