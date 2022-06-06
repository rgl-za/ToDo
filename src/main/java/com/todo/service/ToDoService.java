package com.todo.service;

import com.todo.domain.ToDoDTO;

import java.util.List;

public interface ToDoService {
    public List<ToDoDTO> getToDoList();
}
