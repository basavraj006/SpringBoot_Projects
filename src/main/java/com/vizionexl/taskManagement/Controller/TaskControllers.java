package com.vizionexl.taskManagement.Controller;

import com.vizionexl.taskManagement.Service.TaskService;
import com.vizionexl.taskManagement.dtos.TaskDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController  // it will be the front face thorugh which the internet talks to it
@RequestMapping("/tasks")


public class TaskControllers {
    @Autowired
    private TaskService taskService;

    @GetMapping
    public List<TaskDto> getTask(){
        return taskService.getAllTasks();
    }
    @PostMapping
    public TaskDto createTask(@RequestBody  TaskDto dto){
        return  taskService.createTask(dto);
    }

    // this is for deleting task with its id
    @DeleteMapping("/{id}")
    public String deleteTask(@PathVariable("id") int taskId){
        return taskService.deletetask(taskId);
    }

    @PatchMapping("/updateStatus/{id}")
    public TaskDto updateStatus(@PathVariable("id") int id,@RequestBody TaskDto dto){
        return taskService.updatedStatus(id,dto);
    }

    @PatchMapping("/updateTask/{id}")
    public TaskDto updateTask(@PathVariable("id") int id,@RequestBody TaskDto dto){
        return taskService.updateTask(id,dto);
    }

}
