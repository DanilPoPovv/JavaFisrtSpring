package org.example.taskmanager.controller;

import org.example.taskmanager.Service.TaskService;
import org.example.taskmanager.model.Task;
import org.example.taskmanager.request.CreateTaskRequest;
import org.example.taskmanager.request.UpdateTaskRequest;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class TaskController {
    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping("/task/{taskId}")
    public Task getTask(@PathVariable int taskId) {
        Task task;
        try {
            task = taskService.getTaskById(taskId);
            return task;
        } catch (Throwable e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @DeleteMapping("/task/{taskId}")
    public void DeleteTask(@PathVariable int taskId) {
        try {
            this.taskService.deleteTaskById(taskId);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @PostMapping("/task")
    public Task addTask(@RequestBody CreateTaskRequest request) {
        try {
            var newTask = taskService.addTask(request.getTaskName(), request.getStatus(),request.getUserId());
            return newTask;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
    @PutMapping("/task/{taskId}")
    public void editTask(@PathVariable int taskId,@RequestBody UpdateTaskRequest request) {
        try {
            taskService.editTaskById(taskId,request.getNewTaskName(), request.isStatus());
        }
        catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
