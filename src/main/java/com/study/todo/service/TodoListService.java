package com.study.todo.service;

import com.study.todo.entity.TodoListTodos;
import com.study.todo.repository.TodoListRepository;

import org.springframework.stereotype.Service;

import java.math.BigInteger;

@Service
public class TodoListService {

    private final TodoListRepository todoListRepository;
    //private final UserMyTodoListsRepository userMyTodoListsRepository;
    public TodoListService (TodoListRepository todoListRepository){
        this.todoListRepository = todoListRepository;
        //this.userMyTodoListsRepository = userMyTodoListsRepository;
    }

    public void write(TodoListTodos todos, BigInteger id){

        BigInteger todoListId;
//        todoListId = userMyTodoListsRepository.findByUserId(id).get();
//
//        Optional <TodoList> todoList = todoListRepository.findById(todoListId);

        System.out.println("여기도 TodoList");
        //System.out.println("15살" + todoList);




        System.out.println("여기도 TodoListaaa");
    }


}
