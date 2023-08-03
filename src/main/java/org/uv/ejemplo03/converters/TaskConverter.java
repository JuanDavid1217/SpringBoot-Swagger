/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.uv.ejemplo03.converters;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;
import org.uv.ejemplo03.models.Task;
import org.uv.ejemplo03.models.TaskDTO;
import org.uv.ejemplo03.models.TaskStatus;

/**
 *
 * @author juan
 */
@Component
public class TaskConverter implements IConverter<TaskDTO, Task>{

    @Override
    public Task entity(TaskDTO e) {
        Task task=new Task();
        task.setTitle(e.getTitle());
        task.setDescription(e.getDescription());
        task.setEta(e.getEta());
        
        task.setCreatedDate(LocalDateTime.now());
        task.setFinished(false);
        task.setTaskStatus(TaskStatus.ON_TIME);
        
        return task;
    }

    @Override
    public TaskDTO dto(Task s) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Task> listentities(List<TaskDTO> resourcelist) {
        List<Task> taskList=resourcelist.stream().map(this::entity).collect(Collectors.toList());
        return taskList;
    }

    @Override
    public List<TaskDTO> listdtos(List<Task> resourcelist) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
