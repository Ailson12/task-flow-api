package com.ailson.taskflow.controller;

import com.ailson.taskflow.dto.board.BoardDTO;
import com.ailson.taskflow.request.BoardRequest;
import com.ailson.taskflow.service.BoardService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("board")
public class BoardController {
    @Autowired
    private BoardService boardService;

    @GetMapping
    public ResponseEntity<List<BoardDTO>> findAll() {
        List<BoardDTO> boards = this.boardService.findAll();
        return ResponseEntity.ok(boards);
    }

    @PostMapping
    public void create(@Valid @RequestBody BoardRequest request) {
        this.boardService.create(request);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BoardDTO> findById(
            @PathVariable Long id
    ) {
        BoardDTO board = this.boardService.findById(id);
        return ResponseEntity.ok(board);
    }

    @PutMapping("/{id}")
    public void update(
            @PathVariable Long id,
            @Valid @RequestBody BoardRequest request
    ) {
        this.boardService.update(id, request);
    }
}
