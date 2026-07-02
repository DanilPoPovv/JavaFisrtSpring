package org.example.taskmanager.Service;

import org.example.taskmanager.Repository.TaskRepository;
import org.example.taskmanager.model.Task;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class TaskService {
    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }
    public Task addTask(String taskName, boolean status)
    {
        return taskRepository.save(new Task(taskName, status));
    }

    public Task getTaskById(int taskId){
        return taskRepository.findById(taskId).orElseThrow(() -> new RuntimeException("Task not found"));
    }
    public void deleteTaskById(int taskId){
        taskRepository.deleteById(taskId);
    }
    public void editTaskById(int taskId, String newTaskName, boolean newStatus){
        var task = getTaskById(taskId);
        task.setTitle(newTaskName);
        task.setCompleted(newStatus);
        taskRepository.save(task);
    }
}
