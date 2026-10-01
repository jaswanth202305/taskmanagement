package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.Entity.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

    List<Task> findByStatusIgnoreCase(String status);

    List<Task> findByPriorityIgnoreCase(String priority);

    @Query("SELECT t FROM Task t WHERE " +
           "(:status IS NULL OR LOWER(t.status) = LOWER(:status)) AND " +
           "(:priority IS NULL OR LOWER(t.priority) = LOWER(:priority)) AND " +
           "(:search IS NULL OR LOWER(t.title) LIKE LOWER(CONCAT('%', :search, '%')) OR LOWER(t.description) LIKE LOWER(CONCAT('%', :search, '%')))")
    List<Task> searchTasks(
            @Param("status") String status,
            @Param("priority") String priority,
            @Param("search") String search
    );
}
