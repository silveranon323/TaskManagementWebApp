package com.taskmanagementwebapp.TaskManagementWebApp.repository;

import com.taskmanagementwebapp.TaskManagementWebApp.model.Task;
import com.taskmanagementwebapp.TaskManagementWebApp.model.TaskStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.time.LocalDate;
import java.util.List;



@Repository
public interface TaskRepository extends JpaRepository<Task, Integer> {

    List<Task> findByStatusAndDeletedFalse(TaskStatus status);

    List<Task> findByDueDateBeforeAndStatusAndDeletedFalse(LocalDate date, TaskStatus status);

    List<Task> findAllByDeletedFalseOrderByDueDateAsc();

    List<Task> findByDeletedTrue();
}