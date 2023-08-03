/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package org.uv.ejemplo03.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.uv.ejemplo03.models.Task;
import org.uv.ejemplo03.models.TaskStatus;

/**
 *
 * @author juan
 */
public interface TaskRepository extends JpaRepository<Task, Long>{
    
    public List<Task> findAllByTaskStatus(TaskStatus status);
    
    @Modifying
    @Query(value="UPDATE tasks SET finished=true WHERE id=:id", nativeQuery=true)
    public void markTaskasFinished(@Param("id") long id);
}
