package com.todo.A.to_do.list.Service;

import com.todo.A.to_do.list.Model.modelOfTodolist;
import com.todo.A.to_do.list.Repository.TaskRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {
    @Autowired
TaskRepo task;
    public ResponseEntity<List<modelOfTodolist>> getAllTasks() {
  return new ResponseEntity<>(task.findAll(), HttpStatus.OK);
    }

    public ResponseEntity<String> createTask(modelOfTodolist task) {
        this.task.save(task);
        return new ResponseEntity<>("Success", HttpStatus.OK);
    }

    public ResponseEntity<String> updateTask(int id, modelOfTodolist task1) {
        modelOfTodolist temp = task.findById(id).orElseThrow();
        temp.setCompleted(task1.isCompleted());
        temp.setDescription(task1.getDescription());
        temp.setTitle(task1.getTitle());
        task.save(temp);
        return new ResponseEntity<>("success", HttpStatus.OK);
    }

    public ResponseEntity<String> deleteTask(int id) {
        task.deleteById(id);
        return new ResponseEntity<>("success", HttpStatus.OK);
    }
}
