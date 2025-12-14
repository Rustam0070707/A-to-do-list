package com.todo.A.to_do.list.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public class RequestDTO {
@NotNull
@NotBlank
@Size(min = 1 , max = 15, message = "more or less than 1 less or equal to 15")
    private String title;
@NotNull
@NotBlank
@Size(min = 1 , max = 200, message = "more or less than 1 less or equal to 200")
    private String description;
@NotBlank(groups = CompletedGroup.class,message = "completed is mandatory")
private boolean completed;

    @NotNull(message = "dueDate is mandatory")
    private LocalDate dueDate;


    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
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



    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }
}
