package com.study.todo.service;

import com.study.todo.entity.Todo;
import com.study.todo.entity.TodoList;
import com.study.todo.entity.User;
import com.study.todo.repository.TodoListRepository;
import com.study.todo.repository.TodoRepository;
import com.study.todo.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.Optional;

@Service
public class UserService {


    private final UserRepository userRepository;
    private final TodoListRepository todoListRepository;
    public UserService (UserRepository userRepository, TodoListRepository todoListRepository){
        this.userRepository = userRepository;
        this.todoListRepository = todoListRepository;
    }

    public boolean isDuplicatedUserId (String userId){
        Optional<User> user = userRepository.findByUserId(userId);
        return user.isPresent();
    }

    public boolean isDuplicatedNickname (String nickname){
        Optional<User> user = userRepository.findByNickname(nickname);
        return user.isPresent();
    }



    public void register(User user){
        System.out.println("ㅍㅍ");

        TodoList userTodoList = new TodoList();
        userRepository.save(user);


        userTodoList.setOwnerId(user.getId());
        todoListRepository.save(userTodoList);


        System.out.println("after해봐"+userTodoList);


        user.addTodoList(userTodoList);
        System.out.println("해봐"+userTodoList);
        System.out.println("해봐ㅁaaaa"+user);

    }

    public User login(String userId, String password) {
        /**
         * login.html에서 id, password를 받아오고
         * DB로부터 해당 id 정보를 가져와서 입력받은 password와 대조
         * 일치하면 로그인 성공, 일치하지 않으면 로그인 실패
         */

        Optional<User> user = userRepository.findByUserId(userId);
        if (user.isPresent()){
            if (user.get().getPassword().equals (password)){
                user.get().setLoggedIn(true);
                user.get().setUpdatedAt(new Timestamp(System.currentTimeMillis()));
                userRepository.save(user.get());
                return user.orElseThrow();
            }
        }

        return null;

    }

    public TodoList findMyTodoList (BigInteger id){
        System.out.println("ID 값 :ㅣ "+id);
        return todoListRepository.findByOwnerId(id);
    }

    public Optional<User> findByUserId(Object userId) {
        System.out.println("옵젝트"+userId);
        return userRepository.findByUserId((String) userId);
    }

    public Optional<User> findById(BigInteger id) {
        if (id == null)
            id = BigInteger.valueOf(6);
        return userRepository.findById(id);
    }
}

