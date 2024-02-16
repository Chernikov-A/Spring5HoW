package com.example.Spring4HoW.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "tasks")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long in;
    @Column(nullable = false)
    private String title;
    private String description;
    @Column
    @Enumerated
    private Status status;
    @Column
    private LocalDateTime timeOfCreation = LocalDateTime.now();

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
