package com.taskmanagementwebapp.TaskManagementWebApp.service;

import com.taskmanagementwebapp.TaskManagementWebApp.exception.TaskNotFoundException;
import com.taskmanagementwebapp.TaskManagementWebApp.model.Task;
import com.taskmanagementwebapp.TaskManagementWebApp.model.TaskStatus;
import com.taskmanagementwebapp.TaskManagementWebApp.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;


    public Task createTask(Task task) {
        return taskRepository.save(task);
    }


    public List<Task> getAllTasks() {
        return taskRepository.findAllByDeletedFalseOrderByDueDateAsc();
    }


    public Task getTaskById(int id) {
        return taskRepository.findById(id)
                .filter(task -> !task.isDeleted())
                .orElseThrow(() -> new TaskNotFoundException("Task with ID " + id + " not found"));
    }


    public List<Task> getTasksByStatus(TaskStatus status) {
        return taskRepository.findByStatusAndDeletedFalse(status);
    }


    public List<Task> getOverdueTasks() {
        return taskRepository.findByDueDateBeforeAndStatusAndDeletedFalse(LocalDate.now(), TaskStatus.PENDING);
    }


    public Task updateTask(int id, Task updatedTask) {
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new TaskNotFoundException("Task with ID " + id + " not found"));

        if (updatedTask.getName() != null) task.setName(updatedTask.getName());
        if (updatedTask.getDescription() != null) task.setDescription(updatedTask.getDescription());
        if (updatedTask.getDueDate() != null) task.setDueDate(updatedTask.getDueDate());
        if (updatedTask.getStatus() != null) task.setStatus(updatedTask.getStatus());

        return taskRepository.save(task);
    }


    public void deleteTask(int id) {
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new TaskNotFoundException("Task with ID " + id + " not found"));
        task.setDeleted(true);
        taskRepository.save(task);
    }


    public List<Task> getTasksSortedByDueDate() {
        return taskRepository.findAllByDeletedFalseOrderByDueDateAsc();
    }


    public List<Task> getDeletedTasks() {
        return taskRepository.findByDeletedTrue();
    }
}
