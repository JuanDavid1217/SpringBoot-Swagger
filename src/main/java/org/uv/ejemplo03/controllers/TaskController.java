/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.uv.ejemplo03.controllers;

import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.uv.ejemplo03.models.Task;
import org.uv.ejemplo03.models.TaskDTO;
import org.uv.ejemplo03.models.TaskStatus;
import org.uv.ejemplo03.services.TaskService;

/**
 *
 * @author juan
 */
@RestController
@RequestMapping("/Tasks")
public class TaskController {
    private final TaskService taskService;
    
    public TaskController(TaskService taskService){
        this.taskService=taskService;
    }
    
    @PostMapping
    public Task saveTask(TaskDTO taskdto){
        return taskService.createTask(taskdto);
    }
    
    @GetMapping
    public List<Task> allTasks(){
        return taskService.findAll();
    }
    
    @GetMapping("/status/{status}")
    public List<Task> allTaskByStatus(@PathVariable("status") TaskStatus status){
        return taskService.findAllByTaskStatus(status);
    }
    
    @PatchMapping("/updateTaskasFinished/{id}")
    public ResponseEntity<Void> updateTaskasFinished(@PathVariable("id") long id){
        taskService.updateTaskasFinished(id);
        
        return ResponseEntity.noContent().build();
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteTaskbyID(@PathVariable("id") long id){
        taskService.deleteTask(id);
        return ResponseEntity.noContent().build();
    }
}
