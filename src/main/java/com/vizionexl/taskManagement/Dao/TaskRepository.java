package com.vizionexl.taskManagement.Dao;

import com.vizionexl.taskManagement.dtos.TaskDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends JpaRepository<TaskDto ,Integer> {
}
