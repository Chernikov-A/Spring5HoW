package com.example.Spring4HoW.controllers;

import com.example.Spring4HoW.model.Status;
import com.example.Spring4HoW.model.Task;
import com.example.Spring4HoW.repository.TaskRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/tasks")
public class TaskController {
    private TaskRepository taskRepository;

    @GetMapping()
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    @PostMapping()
    public Task addTask(@RequestBody Task task) {
        return taskRepository.save(task);
    }

    @GetMapping("/status/{status}")
    public List<Task> getTasksByStatus(@PathVariable Status status) {
        return taskRepository.findByStatus(status);
    }

    @PutMapping("/{id}")
    public Task updateTaskStatus(@PathVariable Long id) {
        Task current = taskRepository.findById(id).orElse(null);
        if (current != null) {
            int currentStatusNumber = current.getStatus().ordinal();
            if (current.getStatus() != Status.COMPLETED) {
                currentStatusNumber++;
                current.setStatus(Status.values()[currentStatusNumber]);
            }
        }
        return taskRepository.save(current);
    }

    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable Long id) {
        taskRepository.deleteById(id);
    }

}
