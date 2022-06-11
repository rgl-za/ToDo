package com.todo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.todo.domain.ToDoDTO;
import com.todo.mapper.ToDoMapper;

import java.util.List;

@Service
public class ToDoServiceImpl implements ToDoService{

    @Autowired
    private ToDoMapper toDoMapper;

    @Override
    public List<ToDoDTO> getToDoList() {
        List<ToDoDTO> todoList = toDoMapper.selectToDoList();
        return todoList;
    }

    @Override
    public boolean insertToDoList(ToDoDTO params){
        int queryResult = 0;

        if(params != null)
           queryResult = toDoMapper.insertToDoList(params);

        return (queryResult == 1) ? true : false;
    }

    @Override
    public boolean updateToDoList(ToDoDTO params){
        int queryResult = 0;
        if(params != null)
            queryResult = toDoMapper.updateToDoList(params);
        return (queryResult == 1) ? true : false;
    }
}
