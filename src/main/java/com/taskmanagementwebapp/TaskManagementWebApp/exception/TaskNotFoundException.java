package com.taskmanagementwebapp.TaskManagementWebApp.exception;

public class TaskNotFoundException extends RuntimeException {

    public TaskNotFoundException(String message) {
        super(message);
    }
}