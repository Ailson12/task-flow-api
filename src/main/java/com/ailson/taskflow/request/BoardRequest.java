package com.ailson.taskflow.request;

import com.ailson.taskflow.validation.nonwhitespace.NonWhitespace;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BoardRequest {
    @NotEmpty
    @NonWhitespace
    @Size(min = 5, max = 250)
    private String title;
}
