package com.ailson.taskflow.mapper;

import com.ailson.taskflow.model.Task;
import com.ailson.taskflow.request.TaskRequest;

public class TaskMapper {
    public static Task toCreate(TaskRequest request) {
        Task task = new Task();
        task.setTitle(request.getTitle());
        task.setDescription(request.getDescription());
        task.setOrder(request.getOrder());

        return task;
    }
}
