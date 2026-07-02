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
    public Task addTask(String taskName, boolean status) throws Exception
    {
        return taskRepository.add(new Task(taskName,status));
    }

    public Task getTaskById(int taskId) throws Exception{
        return taskRepository.getById(taskId);
    }
    public void deleteTaskById(int taskId) throws Exception{
        taskRepository.delete(taskId);
    }
    public void editTaskById(int taskId, String newTaskName, boolean newStatus)throws Exception {
        var task = taskRepository.getById(taskId);
        taskRepository.update(task,newTaskName, newStatus);
    }
}
