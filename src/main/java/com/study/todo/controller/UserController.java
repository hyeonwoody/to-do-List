package com.study.todo.controller;

import com.study.todo.entity.User;
import com.study.todo.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {

    private final UserService userService;
    public UserController (UserService userService){
        this.userService = userService;
    }



    @GetMapping ("/register-form")
    public String registerForm(){

        return "/userPages/registerForm";
    }

    @PostMapping("/register-confirm")
    public String registerConfirm(User user){
        System.out.println("스트레스으으으으");
        System.out.println(user);
        userService.register(user);
        return "redirect:/";
    }

}
