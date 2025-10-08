package com.todo.A.to_do.list.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;
@Entity
public class modelOfTodolist {
    @Valid

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
@NotNull(message =  "title is mandatory")
@NotBlank(message = "title is mandatory")
@Size(min = 1 , max = 15, message = "more or less than 1 less or equal to 15")
    private String title;
    @NotNull(message =  "description is mandatory")
    @NotBlank(message = "description is mandatory")
    @Size(min = 1 , max = 200, message = "more or less than 1 less or equal to 50")
    private String description;
    @NotNull(message =  "dueDate is mandatory")
    @Size(min = 1 , max = 50, message = "more or less than 1 less or equal to 50")
    private boolean completed;
    @NotNull(message =  "dueDate is mandatory")
    @Size(min = 5 , max = 20, message = "more or less than 5 less or equal to 20")
    private LocalDate dueDate;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }
}
