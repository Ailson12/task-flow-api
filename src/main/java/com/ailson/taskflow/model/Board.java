package com.ailson.taskflow.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "boards")
public class Board extends BaseEntity<Long> {
    @Column(nullable = false)
    private String title;

    @Column()
    private String description;

    @ManyToMany(mappedBy = "boards")
    private Set<TaskStatus> taskStatus = new HashSet<>();

    public Board(Long id) {
        this.setId(id);
    }
}
