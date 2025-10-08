package com.todo.A.to_do.list.Service;

import com.todo.A.to_do.list.Model.modelOfTodolist;
import com.todo.A.to_do.list.Repository.TaskRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {
    @Autowired
TaskRepo task;
    public List<modelOfTodolist> getAllTasks() {
  return task.findAll();
    }

    public String createTask(modelOfTodolist task) {
        this.task.save(task);
        return "Success";
    }

    public String updateTask(int id, modelOfTodolist task1) {
        modelOfTodolist temp = task.findById(id).orElseThrow();
        temp.setCompleted(task1.isCompleted());
        temp.setDescription(task1.getDescription());
        temp.setTitle(task1.getTitle());
        task.save(task1);
        return "success";
    }

    public String deleteTask(int id) {
        task.deleteById(id);
        return "success";
    }
}
