package com.ailson.taskflow.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "task_status")
@Getter
@Setter
@NoArgsConstructor
public class TaskStatus extends BaseEntity<Long> {
    public TaskStatus(Long id) {
        this.setId(id);
    }

    @Column(nullable = false)
    private String title;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name = "board_task_status", //  Name of the join table
            joinColumns = @JoinColumn(name = "task_status_id"), // Column that references the TaskStatus entity
            inverseJoinColumns = @JoinColumn(name = "board_id") // Column that references the Board entity)
    )
    private Set<Board> boards = new HashSet<>();
}
