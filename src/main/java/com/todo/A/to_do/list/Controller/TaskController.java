package com.todo.A.to_do.list.Controller;

import com.todo.A.to_do.list.Model.modelOfTodolist;
import com.todo.A.to_do.list.Service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("task")
public class TaskController {
    @Autowired
    TaskService service;
@GetMapping("allTasks")
    public List<modelOfTodolist> getAllTasks(){
    return service.getAllTasks();

}
@PostMapping("addTask")
public String createTask(@RequestBody modelOfTodolist task){
    return service.createTask(task);
}
@PutMapping("updateTask/{id}")
    public String updateTask(@PathVariable int id ,@RequestBody modelOfTodolist task1){
    return service.updateTask(id,task1);

}
@DeleteMapping("delete/{id}")
    public String deleteTask(@PathVariable int id){
return service.deleteTask(id);

}

}
