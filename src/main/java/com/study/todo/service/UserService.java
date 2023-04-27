package com.study.todo.service;

import com.study.todo.entity.Todo;
import com.study.todo.entity.TodoList;
import com.study.todo.entity.User;
import com.study.todo.repository.TodoListRepository;
import com.study.todo.repository.TodoRepository;
import com.study.todo.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.Optional;

@Service
public class UserService {


    private final UserRepository userRepository;
    public UserService (UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public boolean isDuplicated (String userId){
        Optional<User> user = userRepository.findByUserId(userId);
        return user.isPresent();
    }


    public void register(User user){
        System.out.println("ㅍㅍ");

//        TodoList userTodoList = new TodoList();
//        todoListRepository.save(userTodoList);
//
//        System.out.println("해봐"+userTodoList);
//        System.out.println("해봐ㅁaaaa"+user);
        userRepository.save(user);
    }

    public boolean login(String userId, String password) {
        /**
         * login.html에서 id, password를 받아오고
         * DB로부터 해당 id 정보를 가져와서 입력받은 password와 대조
         * 일치하면 로그인 성공, 일치하지 않으면 로그인 실패
         */

        Optional<User> user = userRepository.findByUserId(userId);
        if (user.isPresent()){
            if (user.get().getPassword().equals (password))
                return true;
        }
        return false;

    }
}

