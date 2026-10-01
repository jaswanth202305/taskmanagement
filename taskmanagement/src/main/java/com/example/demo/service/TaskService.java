package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.Entity.Task;
import com.example.demo.exception.TaskResponseDTO;
import com.example.demo.repository.TaskRepository;

@Service
public class TaskService {
	
	private final TaskRepository taskRepository;
	
	public TaskService(TaskRepository taskRepository) {
		this.taskRepository = taskRepository;
		
	}
	
	public Task createTask(Task task) {
		return taskRepository.save(task);
	}
	
	public List<Task> getAllTasks() {
		return taskRepository.findAll();
	}
	
	public Task getTaskById(Long Id) {
		return taskRepository.findById(Id)
				.orElse(null);
	}
	
	public Task UpdateTask(Long id, Task task) {
		Task existingTask = taskRepository.findById(id)
				.orElse(null);
	
	
		if(existingTask == null) {
			return null;
		}
		existingTask.setTitle(task.getTitle());
		existingTask.setDescription(task.getDescription());
		existingTask.setStatus(task.getStatus());
		existingTask.setPriority(task.getPriority());
		
		return taskRepository.save(existingTask);
	}
	
	public boolean deleteTask(Long id) {
		Task existingTask = taskRepository.findById(id)
				.orElse(null);
		
		if(existingTask == null) {
			return false;
		}
		
		taskRepository.deleteById(id);
		return true;
	}
	
	
	private TaskResponseDTO convertToResponse(Task task) {
		
		return new TaskResponseDTO(task.getId(), task.getTitle() , task.getDescription(), task.getStatus(), task.getPriority());
	}
	

}
