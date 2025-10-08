package com.todo.A.to_do.list.Repository;

import com.todo.A.to_do.list.Model.modelOfTodolist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepo extends JpaRepository<modelOfTodolist,Integer > {

}
