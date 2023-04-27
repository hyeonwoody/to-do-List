package com.study.todo.dto;

import com.study.todo.service.UserService;
import lombok.Builder;
import lombok.Getter;

import java.util.regex.Pattern;

@Getter
@Builder
public class UserRegisterDto {

    private UserService userService;

    private String userId;

    private String password;
    private String passwordConfirm;

    private String nickname;

    public void validate () {

        if (!password.equals(passwordConfirm)){
            throw new IllegalArgumentException("Password does not match.");
        }

        if (userId == null || userId.isEmpty()) {
            throw new IllegalArgumentException("ID must not be empty.");
        }
        if (!Pattern.matches("^[a-zA-Z0-9+-\\_.]{2,10}", userId)) {
            throw new IllegalArgumentException("Invalid userId format.");
        }

        if (password == null || password.isEmpty()) {
            throw new IllegalArgumentException("Password must not be empty.");
        }
        if (!Pattern.matches("^(?=.*[A-Za-z])(?=.*\\d)(?=.*[~!@#$%^&*()+|=])[A-Za-z\\d~!@#$%^&*()+|=]{7,16}$", password)) {
            throw new IllegalArgumentException("Invalid password format.");
        }

        if (nickname == null || nickname.isEmpty()) {
            throw new IllegalArgumentException("Nickname must not be empty.");
        }
        if (!Pattern.matches("^[a-zA-Z가-힣\\\\s]{2,15}", nickname)) {
            throw new IllegalArgumentException("Invalid nickname format.");
        }
    }
}
