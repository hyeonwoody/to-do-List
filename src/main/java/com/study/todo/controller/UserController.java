package com.study.todo.controller;

import com.study.todo.dto.UserRegisterDto;
import com.study.todo.entity.User;
import com.study.todo.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping ("/login-confirm")
    public ResponseEntity loginConfirm (User user){
        System.out.println("User ID"+ user.getUserId());
        System.out.println("Password" + user.getPassword());

        boolean loginResult = userService.login (user.getUserId(), user.getPassword());

        if (loginResult){
            String message = "You have successfully logged in!";
            //String script = "<script>alert('" + message + "');</script>";

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("<script>alert('" + message + "'); " +
                    "window.location.href='/home';</script>");
            //return "home"+script;
        }
        else {
            String message = "Invalid login credentials.";
            //String script = "<script>alert('" + message + "');</script>";
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("<script>alert('" + message + "'); " +
                    "window.location.href='/';</script>");
            //return "/"+script;
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

            if (userService.isDuplicated(userRegister.getUserId())){
                throw new IllegalArgumentException("ID is already taken. Please choose a different one.");
            }

            dto.validate();
        }
        catch (IllegalArgumentException e){
            System.out.println("Validation error : " + e.getMessage());
            //String errorMessage = e.getMessage();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("<script>alert('" + e.getMessage() + "'); " +
                    "window.location.href='/user/register-form';</script>");
            //return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to register user");
            //return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
        User user = new User();
        user.setUserId(userRegister.getUserId());
        user.setPassword(userRegister.getPassword());
        user.setNickname(userRegister.getNickname());
        userService.register(user);

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("<script>alert('" + "Successfully Registered" + "'); " +
                "window.location.href='/';</script>");
//        RedirectView redirectView = new RedirectView("/", true);
//        HttpHeaders headers = new HttpHeaders();
//        headers.setLocation(URI.create(redirectView.getUrl()));
//
//        return new ResponseEntity<>(headers, HttpStatus.MOVED_PERMANENTLY);
        
        //return new ResponseEntity(userRegisterResponse, HttpStatus.CREATED);
    }

}
