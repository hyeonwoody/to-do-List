package com.study.todo.service;

import com.study.todo.entity.TodoList;
import com.study.todo.repository.TodoListRepository;

import org.springframework.stereotype.Service;

@Service
public class TodoListService {

    private final TodoListRepository todoListRepository;
    public TodoListService (TodoListRepository todoListRepository){
        this.todoListRepository = todoListRepository;
    }

    public void write(TodoList todoList){
        System.out.println("여기도 TodoList");
        todoListRepository.save(todoList);
        System.out.println("여기도 TodoListaaa");
    }
}
