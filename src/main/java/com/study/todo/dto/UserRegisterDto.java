package com.study.todo.dto;

import lombok.Builder;
import lombok.Getter;

import java.util.regex.Pattern;

@Getter
@Builder
public class UserRegisterDto {


    private String userId;

    private String password;
    private String passwordConfirm;

    private String nickname;

    public void validate () {

        if (!password.equals(passwordConfirm)){
            throw new IllegalArgumentException("password and passwordConfirm must match password : "+password + "confirom "+passwordConfirm);
        }

        if (userId == null || userId.isEmpty()) {
            throw new IllegalArgumentException("userId must not be empty");
        }
        if (!Pattern.matches("^[a-zA-Z0-9+-\\_.]{2,10}", userId)) {
            throw new IllegalArgumentException("Invalid userId format");
        }

        if (password == null || password.isEmpty()) {
            throw new IllegalArgumentException("password must not be empty");
        }
        if (!Pattern.matches("^(?=.*[A-Za-z])(?=.*\\d)(?=.*[~!@#$%^&*()+|=])[A-Za-z\\d~!@#$%^&*()+|=]{7,16}$", password)) {
            throw new IllegalArgumentException("Invalid password format");
        }

        if (nickname == null || nickname.isEmpty()) {
            throw new IllegalArgumentException("nickname must not be empty");
        }
        if (!Pattern.matches("^[a-zA-Z가-힣\\\\s]{2,15}", nickname)) {
            throw new IllegalArgumentException("Invalid nickname format");
        }
    }
}
