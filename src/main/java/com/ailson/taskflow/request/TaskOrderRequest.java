package com.ailson.taskflow.request;

import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class TaskOrderRequest {
    @NotEmpty
    private List<TaskOrderLineRequest> tasks;
}
