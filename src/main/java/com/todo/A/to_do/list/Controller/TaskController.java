package com.todo.A.to_do.list.Controller;

import com.todo.A.to_do.list.Model.modelOfTodolist;
import com.todo.A.to_do.list.Service.TaskService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("task")
public class TaskController {
    @Autowired
    TaskService service;
@GetMapping("allTasks")
    public ResponseEntity<List<modelOfTodolist>> getAllTasks(){
    return service.getAllTasks();

}
@PostMapping("addTask")
public ResponseEntity<String> createTask(@Valid @RequestBody modelOfTodolist task){
    return service.createTask(task);
}
@PutMapping("updateTask/{id}")
    public ResponseEntity<String> updateTask(@PathVariable int id , @Valid @RequestBody modelOfTodolist task1){
    return service.updateTask(id,task1);

}
@DeleteMapping("delete/{id}")
    public ResponseEntity<String> deleteTask(@PathVariable int id){
return service.deleteTask(id);

}
@ResponseStatus(HttpStatus.BAD_REQUEST)
@ExceptionHandler(MethodArgumentNotValidException.class)
public Map<String, String> handleValidationException(MethodArgumentNotValidException ex) {


    Map<String, String> errors = new HashMap<>();
    ex.getBindingResult().getAllErrors().forEach(
            (error) -> {
                String fieldName = ((FieldError) error).getField();
                String errorMessage = error.getDefaultMessage();
                errors.put(fieldName, errorMessage);

            });
    return errors;
}
}
