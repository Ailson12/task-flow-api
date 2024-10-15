package com.ailson.taskflow.controller;

import com.ailson.taskflow.dto.taskStatus.TaskStatusDTO;
import com.ailson.taskflow.service.TaskStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("task-status")
public class TaskStatusController {
    @Autowired
    private TaskStatusService taskStatusService;

    @GetMapping("/all")
    public ResponseEntity<List<TaskStatusDTO>> findAll() {
        List<TaskStatusDTO> taskStatusDTOS = this.taskStatusService.findAll();
        return ResponseEntity.ok(taskStatusDTOS);
    }
}
