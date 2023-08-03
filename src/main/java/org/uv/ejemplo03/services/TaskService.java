/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.uv.ejemplo03.services;

import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.uv.ejemplo03.converters.TaskConverter;
import org.uv.ejemplo03.exceptions.Exceptions;
import org.uv.ejemplo03.models.Task;
import org.uv.ejemplo03.models.TaskDTO;
import org.uv.ejemplo03.models.TaskStatus;
import org.uv.ejemplo03.repository.TaskRepository;

/**
 *
 * @author juan
 */
@Service
public class TaskService {
    
    private final TaskRepository taskRepository;
    private final TaskConverter taskConverter;
    
    public TaskService(TaskRepository taskRepository, TaskConverter taskConverter){
        this.taskRepository = taskRepository;
        this.taskConverter=taskConverter;
    }
    
    public Task createTask(TaskDTO taskDTO){
        
        Task t=taskConverter.entity(taskDTO);
        return taskRepository.save(t);
    }
    
    public List<Task> findAll(){
        return taskRepository.findAll();
    }
    
    public List<Task> findAllByTaskStatus(TaskStatus status){
        return taskRepository.findAllByTaskStatus(status);
    }
    
    @Transactional
    public void updateTaskasFinished(long id){
        Optional<Task> task=taskRepository.findById(id);
        
        if(task.isEmpty()){
            throw new Exceptions("Task not found", HttpStatus.NOT_FOUND);
        }
        taskRepository.markTaskasFinished(id);
    }
    
    public void deleteTask(long id){
        Optional<Task>  task = taskRepository.findById(id);
        
        if(task.isEmpty()){
            throw new Exceptions("Task not Found", HttpStatus.NOT_FOUND);
        }
        
        taskRepository.deleteById(id);
    }
}
