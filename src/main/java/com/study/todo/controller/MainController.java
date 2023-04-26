package com.study.todo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller

public class MainController {

    @GetMapping("/") //해당 주소로 들어올 때
    public String main(){
        //.addAttribute("list", todoService.todoList());
        return "index";
    }
}
