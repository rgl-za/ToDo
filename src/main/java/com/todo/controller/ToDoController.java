package com.todo.controller;

import com.todo.domain.ToDoDTO;
import com.todo.service.ToDoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class ToDoController {

    @Autowired
    private ToDoService toDoService;

    @GetMapping(value = "/")
    public String todoList(Model model){
        List<ToDoDTO> toDoList = toDoService.getToDoList();
        model.addAttribute("toDoList", toDoList);
        model.addAttribute("todo", new ToDoDTO());
        return "index";
    }

    @PostMapping(value = "/todo/register.do")
    public String insertToDoList(Model model, ToDoDTO params){
            toDoService.insertToDoList(params);
            return "redirect:/";
    }


}
