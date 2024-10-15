package com.ailson.taskflow.mapper;

import com.ailson.taskflow.dto.taskStatus.TaskStatusDTO;
import com.ailson.taskflow.model.TaskStatus;

public class TaskStatusMapper {
    public static TaskStatusDTO toDTO(TaskStatus entity) {
        return new TaskStatusDTO(
                entity.getId(),
                entity.getTitle()
        );
    }
}
