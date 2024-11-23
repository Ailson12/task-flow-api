package com.ailson.taskflow.dto.board;

import com.ailson.taskflow.dto.taskStatus.TaskStatusDTO;

import java.util.List;

public record BoardDTO(Long id, String title, String description, List<TaskStatusDTO> taskStatusList) {}
