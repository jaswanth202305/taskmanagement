package com.example.demo.Entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tasks")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Task {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message = "Title is required")
	@Column(nullable = false)
	private String title;
	
	@Column(length = 1000)
	private String description;
	
	private String status; // PENDING, IN_PROGRESS, COMPLETED, CANCELLED
	
	private String priority; // LOW, MEDIUM, HIGH, URGENT

	private LocalDate dueDate;

	@CreationTimestamp
	@Column(updatable = false)
	private LocalDateTime createdAt;

	@UpdateTimestamp
	private LocalDateTime updatedAt;

	@PrePersist
	public void prePersist() {
		if (this.status == null || this.status.trim().isEmpty()) {
			this.status = "PENDING";
		}
		if (this.priority == null || this.priority.trim().isEmpty()) {
			this.priority = "MEDIUM";
		}
	}
}
