package com.example.demo.service;

import com.example.demo.model.Task;
import com.example.demo.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {
    private final TaskRepository taskRepository;
    private Long nextId=1L;

    @Autowired
    public TaskService(TaskRepository taskRepository){
        this.taskRepository=taskRepository;
    }

public List<Task> getAllTasks(){
return taskRepository.findAll();
}

public Task getTaskById(Long id){
        return taskRepository.findbyId(id);
}

public Task addTask(Task task){
        task.setId(nextId++);
      return   taskRepository.save(task);
}

public Task updateTask(Task task){
        return taskRepository.update(task);
}

public boolean deleteTask(Long id){
        return taskRepository.delete(id);
}

}
