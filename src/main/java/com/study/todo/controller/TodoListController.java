package com.study.todo.controller;

import com.study.todo.entity.Todo;
import com.study.todo.service.TodoListService;
import com.study.todo.service.TodoService;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.Arrays;


@Controller //브라우저와 통신
@RequestMapping("/todoList")
public class TodoListController {

    private final TodoListService todoListService;
    public TodoListController (TodoListService todoListService){
        this.todoListService =
                todoListService;
    }

    @PostMapping("/write-todo")
    public String writeTodo (HttpSession session, Todo todo){//String title, String memo //@RequestParam("title") String title, @RequestParam("memo") String memo
        System.out.println("여기까지는 왔다");
        System.out.println("유저아이디"+session.getAttribute("userId"));

        System.out.println("투두"+todo);
        //todoListService.write(todo);//data Base 저장


        //System.out.println(todo);
        return "redirect:/main";
    }

}
