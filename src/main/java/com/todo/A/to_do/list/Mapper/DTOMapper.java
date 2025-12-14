package com.todo.A.to_do.list.Mapper;

import com.todo.A.to_do.list.DTO.RequestDTO;
import com.todo.A.to_do.list.DTO.ResponseDTO;
import com.todo.A.to_do.list.Model.modelOfTodolist;

public class DTOMapper {
    public static ResponseDTO toDTO (modelOfTodolist TList ){
        ResponseDTO DTO = new ResponseDTO();

        DTO.setDescription(TList.getDescription());
        DTO.setTitle(TList.getTitle());
        DTO.setDueDate(TList.getDueDate());
        return DTO;

    }
}
