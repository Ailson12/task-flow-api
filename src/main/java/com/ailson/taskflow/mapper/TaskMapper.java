package com.ailson.taskflow.mapper;

import com.ailson.taskflow.dto.task.TaskDTO;
import com.ailson.taskflow.dto.taskStatus.TaskStatusDTO;
import com.ailson.taskflow.model.Task;
import com.ailson.taskflow.model.TaskStatus;
import com.ailson.taskflow.request.TaskRequest;

public class TaskMapper {
    public static TaskDTO toDTO(Task task) {
        TaskDTO dto = new TaskDTO();
        dto.setTitle(task.getTitle());
        dto.setDescription(task.getDescription());
        dto.setOrder(task.getOrder());

        TaskStatus taskStatus = task.getTaskStatus();
        TaskStatusDTO taskStatusDTO = new TaskStatusDTO(
                taskStatus.getId(),
                taskStatus.getTitle()
        );
        dto.setTaskStatus(taskStatusDTO);

        return dto;
    }

    public static Task toCreate(TaskRequest request) {
        Task task = new Task();
        task.setTitle(request.getTitle());
        task.setDescription(request.getDescription());

        Integer order = request.getOrder();
        task.setOrder(order == null ? 0 : order);

        return task;
    }
}
