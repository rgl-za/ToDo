package com.todo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.todo.domain.ToDoDTO;
import com.todo.mapper.ToDoMapper;

import java.util.Collections;
import java.util.List;

@Service
public class ToDoServiceImpl implements ToDoService{

    @Autowired
    private ToDoMapper toDoMapper;

    @Override
    public List<ToDoDTO> getToDoList() {
        List<ToDoDTO> todoList = Collections.emptyList();
        return todoList;
    }
}
