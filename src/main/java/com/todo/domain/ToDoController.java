package com.todo.domain;

import com.todo.service.ToDoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ToDoController {

    @Autowired
    private ToDoService toDoService;

    @GetMapping(value = "/todo/list.do")
    public String todoList(Model model){
        List<ToDoDTO> toDoList = toDoService.getToDoList();
        model.addAttribute("toDoList", toDoList);
        return "todo/list";
    }
}
