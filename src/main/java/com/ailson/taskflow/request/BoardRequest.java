package com.ailson.taskflow.request;

import com.ailson.taskflow.validation.nonwhitespace.NonWhitespace;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class BoardRequest {
    @NotEmpty
    @NonWhitespace
    @Size(min = 5, max = 250)
    private String title;

    @Size(min = 5, max = 500)
    private String description;

    @NotNull
    private List<Long> taskStatusIds;
}
