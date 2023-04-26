package com.study.todo.service;

import com.study.todo.entity.User;
import com.study.todo.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {


    private final UserRepository userRepository;
    public UserService (UserRepository userRepository){
        this.userRepository = userRepository;
    }


    public void register(User user){
        System.out.println("여기ㅓ");
        userRepository.save(user);
    }
}

