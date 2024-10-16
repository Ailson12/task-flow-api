package com.ailson.taskflow.controller;

import com.ailson.taskflow.request.TaskRequest;
import com.ailson.taskflow.service.TaskService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("task")
public class TaskController {
    @Autowired
    private TaskService taskService;

    @PostMapping
    public void create(@Valid @RequestBody TaskRequest request) {
        this.taskService.create(request);
    }
}
