package com.ailson.taskflow.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TaskOrderLineRequest {
    @NotNull
    private Long taskId;

    @PositiveOrZero
    private Integer order;

    @NotNull
    private Long taskStatusId;
}
