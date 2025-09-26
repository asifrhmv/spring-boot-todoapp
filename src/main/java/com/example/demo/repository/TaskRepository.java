package com.example.demo.repository;


import com.example.demo.model.Task;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

@Repository
public class TaskRepository {
    private final List<Task>tasks=new ArrayList<>();

    // Butun tasklara chatmaq ucun
    public List<Task>findAll(){
        return tasks;
    }

    // Task elave etmek ucun
    public Task save(Task task){
        tasks.add(task);
        return task;
    }

    // ID-ye gore task tapmaq ucun
    public Task findbyId(Long id) {
        return tasks.stream()
                .filter(t -> t.getId() == id)
                .findFirst()
                .orElse(null);
    }

    // Movcud tapshirigi yenilemek ucun
public Task update(Task updatedTask){
        Task existing=findbyId(updatedTask.getId());
        if(existing!=null){
            existing.setTitle(updatedTask.getTitle());
            existing.setDescription(updatedTask.getDescription());
            existing.setCompleted(updatedTask.isCompleted());
        }
        return existing;
}

// Task-i silmek ucun
    public boolean delete(Long id) {
        return tasks.removeIf(task -> id.equals(task.getId()));
    }
}


