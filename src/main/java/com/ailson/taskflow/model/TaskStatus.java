package com.ailson.taskflow.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "task_status")
@Getter
@Setter
public class TaskStatus extends BaseEntity<Long> {
    @Column(nullable = false)
    private String title;
}
