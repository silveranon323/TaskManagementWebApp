package com.taskmanagementwebapp.TaskManagementWebApp.controller;

import com.taskmanagementwebapp.TaskManagementWebApp.model.Task;
import com.taskmanagementwebapp.TaskManagementWebApp.model.TaskStatus;
import com.taskmanagementwebapp.TaskManagementWebApp.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/tasks")
public class TaskController {

    @Autowired
    private TaskService taskService;


    @PostMapping
    public Task createTask(@RequestBody Task task){
        return taskService.createTask(task);
    }


    @GetMapping
    public List<Task> getAllTasks(){
        return taskService.getAllTasks();
    }


    @GetMapping("/{id}")
    public Task getTaskById(@PathVariable int id){
        return taskService.getTaskById(id);
    }


    @GetMapping("/status")
    public List<Task> getTasksByStatus(@RequestParam TaskStatus status) {
        return taskService.getTasksByStatus(status);
    }


    @GetMapping("/overdue")
    public List<Task> getOverdueTasks() {
        return taskService.getOverdueTasks();
    }


    @PutMapping("/{id}")
    public Task updateTask(@PathVariable int id, @RequestBody Task task) {
        return taskService.updateTask(id, task);
    }


    @DeleteMapping("/{id}")
    public String deleteTask(@PathVariable int id) {
        taskService.deleteTask(id);
        return "Task deleted successfully";
    }


    @GetMapping("/sort")
    public List<Task> getSortedTasks() {
        return taskService.getTasksSortedByDueDate();
    }


    @GetMapping("/deleted")
    public List<Task> getDeletedTasks() {
        return taskService.getDeletedTasks();
    }
}
