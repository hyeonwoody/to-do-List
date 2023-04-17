package com.study.todo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PageController {

    @GetMapping("/") //해당 주소로 들어올 때
    @ResponseBody //여기로 들어와라라
    public String main(){

        return "Hello World";
    }
}
