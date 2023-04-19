package com.study.todo.controller;

import com.study.todo.entity.Todo;
import com.study.todo.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.List;

@Controller //브라우저와 통신
public class TodoController {

    @Autowired
    private TodoService todoService;

    @GetMapping("/") //해당 주소로 들어올 때
    public String main(Model model){
        model.addAttribute("list", todoService.todoList());
        return "todo";
    }

    @PostMapping("/createTodo")
    public String createTodo(Todo todo){//String title, String memo //@RequestParam("title") String title, @RequestParam("memo") String memo

        todoService.write(todo);//data Base 저장


        System.out.println(todo.getTitle());
        System.out.println(todo.getMemo());
        System.out.println("한글 몰라요");
        return "redirect:/";
    }

    @GetMapping("/showMemo") //localhost:12000/showMemo?id=24
    public String showMemo (Model model, BigInteger id){
        model.addAttribute("todo", todoService.todoView(id));

        return "showMemo";
    }

    @ExceptionHandler(Exception.class)
    public String handleException (Exception e){
        System.out.println(e);
        return "error";
    }
}
