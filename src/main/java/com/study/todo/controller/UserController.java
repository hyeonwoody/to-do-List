package com.study.todo.controller;

import com.study.todo.dto.UserRegisterDto;
import com.study.todo.entity.User;
import com.study.todo.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

        return "userPages/registerForm";
    }

    @PostMapping ("/login-confirm")
    public String loginConfirm (User user){
        boolean loginResult = userService.login (user);
        if (loginResult){
            return "home";
        }
        else {
            return "index";
        }
    }


    @PostMapping("/register-confirm")
    public ResponseEntity registerConfirm(UserRegisterDto userRegister){
        UserRegisterDto dto = UserRegisterDto.builder()
                        .userId(userRegister.getUserId())
                        .password(userRegister.getPassword())
                        .passwordConfirm(userRegister.getPasswordConfirm())
                        .nickname((userRegister.getNickname()))
                        .build();
        try {
            dto.validate();
        }
        catch (IllegalArgumentException e){
            System.out.println("Validation error : " + e.getMessage());
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
        User user = new User();
        user.setUserId(userRegister.getUserId());
        user.setPassword(userRegister.getPassword());
        user.setNickname(userRegister.getNickname());
        userService.register(user);
        return new ResponseEntity(HttpStatus.CREATED);
        //return new ResponseEntity(userRegisterResponse, HttpStatus.CREATED);
    }

}
