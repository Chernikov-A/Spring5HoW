package com.example.Spring4HoW.repository;

import com.example.Spring4HoW.model.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.Spring4HoW.model.Task;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {
    public List<Task> findByStatus(Status status);


}
