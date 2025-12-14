package com.todo.A.to_do.list.Service;

import com.todo.A.to_do.list.DTO.RequestDTO;
import com.todo.A.to_do.list.DTO.ResponseDTO;
import com.todo.A.to_do.list.Mapper.DTOMapper;
import com.todo.A.to_do.list.Model.modelOfTodolist;
import com.todo.A.to_do.list.Repository.TaskRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {
    @Autowired
TaskRepo repoTask;
    public ResponseEntity<List<ResponseDTO>> getAllTasks() {
        List<modelOfTodolist> listOfTasks = repoTask.findAll();
       List<ResponseDTO> DTOOfLists  = listOfTasks.stream().map(DTOMapper::toDTO).toList();

  return new ResponseEntity<>(DTOOfLists, HttpStatus.OK);
    }

    public ResponseEntity<ResponseDTO> createTask(RequestDTO task) {
        modelOfTodolist model = new modelOfTodolist();
        model.setCompleted(false);
        model.setTitle(task.getTitle());
        model.setDescription(task.getDescription());
        model.setDueDate(task.getDueDate());
        repoTask.save(model);
        return new ResponseEntity<>(DTOMapper.toDTO(model), HttpStatus.OK);
    }

    public ResponseEntity<String> updateTask(int id, RequestDTO task1) {
        modelOfTodolist temp = repoTask.findById(id).orElseThrow();
        temp.setCompleted(task1.isCompleted());
        temp.setDescription(task1.getDescription());
        temp.setTitle(task1.getTitle());
        temp.setDueDate(task1.getDueDate());
        repoTask.save(temp);
        return new ResponseEntity<>("success", HttpStatus.OK);
    }

    public ResponseEntity<String> deleteTask(int id) {
        repoTask.deleteById(id);
        return new ResponseEntity<>("success", HttpStatus.OK);
    }
}
