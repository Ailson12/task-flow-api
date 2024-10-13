package com.ailson.taskflow.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "boards")
public class Board extends BaseEntity<Long> {
    @Column(nullable = false)
    private String title;
}
