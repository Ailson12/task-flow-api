package com.ailson.taskflow.dto.task;

import com.ailson.taskflow.dto.taskStatus.TaskStatusDTO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TaskDTO {
    private Long id;
    private String title;
    private String description;
    private Integer order;
    private TaskStatusDTO taskStatus;
}
