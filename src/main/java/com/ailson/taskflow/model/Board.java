package com.ailson.taskflow.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "boards")
public class Board extends BaseEntity<Long> {
    @Column(nullable = false)
    private String title;

    @ManyToMany(mappedBy = "boards", cascade = CascadeType.ALL)
    private Set<TaskStatus> taskStatus = new HashSet<>();
}
