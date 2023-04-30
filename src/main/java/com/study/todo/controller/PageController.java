package com.study.todo.controller;

import com.study.todo.service.TodoListTodosService;
import com.study.todo.service.TodoService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.math.BigInteger;

@Controller //브라우저와 통신
public class PageController {

    private final TodoListTodosService todoListTodosService;
    public PageController (TodoListTodosService todoListTodosService){
        this.todoListTodosService = todoListTodosService;
    }

    @GetMapping("/hello") //해당 주소로 들어올 때
    @ResponseBody //여기로 들어와라라
    public String hello(){

        return "hello";
    }

    @GetMapping("/main") //해당 주소로 들어올 때
    public String main(Model model, HttpSession session, HttpServletRequest request){
        final BigInteger id = (BigInteger) session.getAttribute("id");
        System.out.println("메인에서 ID:"+id);
        model.addAttribute("yourlist", todoListTodosService.todoList(id));
        model.addAttribute("HWlist", todoListTodosService.todoList(BigInteger.valueOf(1)));

        String[] checkedIds = request.getParameterValues("item-id");
        System.out.println("체크박스"+checkedIds);
        if (checkedIds != null) {
            for (String idStr : checkedIds) {
                BigInteger itemId = new BigInteger(idStr);
                // Do something with the checked item id
                System.out.println("체킃킃켗ㅋ츠,켗켗켗");
            }
        }
        else{
            System.out.println("ㅗㄸㄲㄸㄲㄸㄲ");
        }
        return "main";





    }

    @GetMapping("/home/explore")
    public String explore(){
        System.out.println("fsjhfkxcvjxkcvjxcklvjxc");
        return "home";
    }



    @ExceptionHandler(Exception.class)
    public String handleException (Exception e){
        System.out.println(e);
        return "error";
    }

}
