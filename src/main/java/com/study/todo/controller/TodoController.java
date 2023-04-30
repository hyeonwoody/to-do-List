package com.study.todo.controller;

import com.study.todo.entity.Todo;
import com.study.todo.service.TodoService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.Arrays;


@Controller //브라우저와 통신
public class TodoController {

    private final TodoService todoService;
    public TodoController (TodoService todoService){
        this.todoService = todoService;
    }

    @PostMapping("/createTodo")
    public String createTodo(Todo todo){//String title, String memo //@RequestParam("title") String title, @RequestParam("memo") String memo
        System.out.println("여기까지는 왔다");

        //todoListService.write(todoList);
        todoService.write(todo);//data Base 저장


        System.out.println(todo);
        return "redirect:/home";
    }

    @GetMapping("/home") //해당 주소로 들어올 때
    public String main(Model model){
        model.addAttribute("list", todoService.todoList());
        return "home";
    }




}
