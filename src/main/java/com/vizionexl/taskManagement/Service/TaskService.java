package com.vizionexl.taskManagement.Service;

import com.vizionexl.taskManagement.Dao.TaskRepository;
import com.vizionexl.taskManagement.dtos.TaskDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TaskService {
    @Autowired
    private TaskRepository taskRepository;


    public List<TaskDto> getAllTasks() {
        return taskRepository.findAll();
    }


    public TaskDto createTask(TaskDto dto) {
        return taskRepository.save(dto);
    }

    public String deletetask(int id){
        taskRepository.deleteById(id);
        return "task with id "+id+" is deleted";
    }

    public TaskDto updatedStatus(int id,TaskDto dto) {
        Optional<TaskDto> taskDtoOptional= taskRepository.findById(id);
        TaskDto savedTask = taskDtoOptional.get();
        savedTask.setCompleted(dto.isCompleted());
        return taskRepository.save(savedTask);
    }


    public TaskDto updateTask(int id,TaskDto dto){
        Optional<TaskDto> bookOptional = taskRepository.findById(id);
        TaskDto savedTask = bookOptional.get();

        if (dto.getTask() != null ){
            savedTask.setTask(dto.getTask());
        }
        return taskRepository.save(savedTask);
    }
}
