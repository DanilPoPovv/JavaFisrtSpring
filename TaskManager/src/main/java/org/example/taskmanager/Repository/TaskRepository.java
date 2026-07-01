package org.example.taskmanager.Repository;

import org.example.taskmanager.model.Task;

import java.util.List;

public interface TaskRepository {
    Task getById(int id) throws Exception;
    Task add(Task task) throws Exception;
    void delete(int id) throws Exception;
    List<Task> getAll();
    void Update(Task task) throws Exception;
}
