package com.ailson.taskflow.controller;

import com.ailson.taskflow.dto.task.TaskDTO;
import com.ailson.taskflow.request.TaskOrderRequest;
import com.ailson.taskflow.request.TaskRequest;
import com.ailson.taskflow.service.TaskService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("task")
public class TaskController {
    @Autowired
    private TaskService taskService;

    @GetMapping("/board")
    public ResponseEntity<List<TaskDTO>> findAllByBoard(
            @RequestParam Long boardId
    ) {
        List<TaskDTO> tasks = this.taskService.findAllByBoard(boardId);
        return ResponseEntity.ok(tasks);
    }

    @PostMapping
    public void create(@Valid @RequestBody TaskRequest request) {
        this.taskService.create(request);
    }

    @PutMapping("/{id}")
    public void update(
            @PathVariable Long id,
            @Valid @RequestBody TaskRequest request
    ) {
        this.taskService.update(id, request);
    }

    @PutMapping("/update-order")
    public void updateOrder(
            @Valid @RequestBody TaskOrderRequest request
    ) {
        this.taskService.updateOrder(request);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        this.taskService.delete(id);
    }
}
