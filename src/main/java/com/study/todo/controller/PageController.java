package com.study.todo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller //브라우저와 통신
public class PageController {

    @GetMapping("/hello") //해당 주소로 들어올 때
    @ResponseBody //여기로 들어와라라
    public String hello(){

        return "hello";
    }

    @GetMapping("/main")
    public String main(){

        return "main";
    }

    @GetMapping("/home/explore")
    public String explore(){
        System.out.println("fsjhfkxcvjxkcvjxcklvjxc");
        return "home";
    }


}
