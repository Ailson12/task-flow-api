package com.ailson.taskflow.controller;

import com.ailson.taskflow.request.BoardRequest;
import com.ailson.taskflow.service.BoardService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("board")
public class BoardController {
    @Autowired
    private BoardService boardService;

    @PostMapping
    public void create(@Valid @RequestBody BoardRequest request) {
        this.boardService.create(request);
    }
}
