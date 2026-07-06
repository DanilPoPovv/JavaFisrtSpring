package org.example.taskmanager.Service;

import org.example.taskmanager.Repository.TaskRepository;
import org.example.taskmanager.Repository.UserRepository;
import org.example.taskmanager.model.Task;
import org.example.taskmanager.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class TaskService {
    private final TaskRepository taskRepository;
    private final UserRepository userRepository;
    public TaskService(TaskRepository taskRepository, UserRepository userRepository) {
        this.taskRepository = taskRepository;
        this.userRepository = userRepository;
    }
    public Task addTask(String taskName, boolean status, Integer userId)
    {
        User user;
        Task task = new Task();
        if (userId != null) {
            userRepository.findById(userId)
                    .ifPresent(task::setUser);
        }
        task.setTitle(taskName);
        task.setCompleted(status);
        return taskRepository.save(task);
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
