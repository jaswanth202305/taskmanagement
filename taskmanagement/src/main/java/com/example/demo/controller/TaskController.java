package com.example.taskmanagement.controller;



import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.*;

import com.example.demo.dto.TaskRequestDTO;
import com.example.demo.exception.TaskResponseDTO;
import com.example.demo.service.TaskService;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    private final com.example.demo.service.TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping
    public TaskResponseDTO createTask(
            @Valid @RequestBody TaskRequestDTO request) {

        return taskService.createTask(request);
    }

    @GetMapping
    public List<TaskResponseDTO> getAllTasks() {

        return taskService.getAllTasks();
    }

    @GetMapping("/{id}")
    public TaskResponseDTO getTaskById(
            @PathVariable Long id) {

        return taskService.getTaskById(id);
    }

    @PutMapping("/{id}")
    public TaskResponseDTO updateTask(
            @PathVariable Long id,
            @Valid @RequestBody TaskRequestDTO request) {

        return taskService.UpdateTask(id, request);
    }

    @DeleteMapping("/{id}")
    public String deleteTask(
            @PathVariable Long id) {

        taskService.deleteTask(id);

        return "Task deleted successfully";
    }
}