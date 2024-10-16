package com.ailson.taskflow.request;

import com.ailson.taskflow.validation.nonwhitespace.NonWhitespace;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TaskRequest {
    @NotEmpty
    @NonWhitespace
    @Size(min = 5, max = 250)
    private String title;

    @NotEmpty
    @NonWhitespace
    @Size(min = 5, max = 500)
    private String description;

    @NotNull
    @PositiveOrZero
    private Integer order;

    @NotNull
    @PositiveOrZero
    private Long taskStatusId;

    @NotNull
    @PositiveOrZero
    private Long boardId;
}
