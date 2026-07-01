package org.example.taskmanager.Repository;

import org.example.taskmanager.model.Task;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class MemoryTaskRepository implements TaskRepository{
    private int lastTaskId;
    ArrayList<Task> tasks = new ArrayList<>();
    @Override
    public Task getById(int id) throws Exception{
        var task = tasks.stream().filter(x -> x.getId() == id).findFirst().orElse(null);
        if(task == null) {
            throw new Exception("There is not task with id " + id );
        }
        return task;
    }

    @Override
    public Task add(Task task) throws Exception{
        if(task == null){
            throw new Exception("Task is empty");
        }
        if(tasks.stream().anyMatch(x -> x.getTitle().equals(task.getTitle()))){
            throw new Exception("Task with name " + task.getTitle() + " already exsists");
        }
        task.setId(++lastTaskId);
        tasks.add(task);
        return task;
    }

    @Override
    public void delete(int id) throws Exception{
        var task = getById(id);
        tasks.remove(task);
    }

    @Override
    public List<Task> getAll() {
        return new ArrayList<>(tasks);
    }

    @Override
    public void Update(Task task) throws Exception{
        var updatableTask = getById(task.getId());
        updatableTask.setTitle(task.getTitle());
        updatableTask.setCompleted(task.isCompleted());
        
    }
}
