package com.ailson.taskflow.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
@MappedSuperclass
public abstract class BaseEntity<T> {
    // Getters e Setters
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // ID generation strategy
    private T id;

    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @PrePersist  // Method executed before persisting a new record
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    @PreUpdate  // Method executed before updating an existing record
    protected void onUpdate() {
        this.updatedAt = LocalDateTime.now();
    }

}
