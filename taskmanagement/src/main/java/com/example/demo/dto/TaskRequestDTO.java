package com.example.demo.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class TaskRequestDTO {
	
	@NotBlank(message = "Title is required")
	@Size(min = 3, max = 100, message = "Ttile must be between 3 and 100 characters")
	private String title;
	
	@Size(max = 500, message = "Description cannot exceed 500 characters")
	private String description;
	
	@NotBlank(message = "Status is required")
	private String status;
	
	@NotBlank(message = "priority is required")
	private String priority;
	
	public String getTitle() {
		return title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	
	
}
