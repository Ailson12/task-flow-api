package com.ailson.taskflow.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "tasks")
public class Task extends BaseEntity<Long> {
    @Column(nullable = false)
    private String title;

    @Column(name = "task_order", nullable = false)
    private Integer order;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String description;

    @ManyToOne
    @JoinColumn(name = "task_status_id", nullable = false)
    private TaskStatus taskStatus;

    @ManyToOne
    @JoinColumn(name = "board_id", nullable = false)
    private Board board;
}
