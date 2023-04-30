package com.study.todo.service;


import com.study.todo.entity.TodoList;
import com.study.todo.entity.TodoListTodos;
import com.study.todo.entity.User;
import com.study.todo.repository.TodoListRepository;
import com.study.todo.repository.TodoListTodosRepository;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;

@Service
public class TodoListTodosService {

    private final TodoListRepository todoListRepository;
    private final TodoListTodosRepository todoListTodosRepository;
    public TodoListTodosService(TodoListTodosRepository todoListTodosRepository, TodoListRepository todoListRepository){
        this.todoListTodosRepository = todoListTodosRepository;
        this.todoListRepository = todoListRepository;
    }


    public List<TodoListTodos> todoList(BigInteger id){
        System.out.println("아이디 id"+id);
        if (id == null)
            id = BigInteger.valueOf(6);
        System.out.println("after 아이디 id"+id);
        TodoList todoList = todoListRepository.findByOwnerId(id);
        return todoListTodosRepository.findByTodoListId(todoList.getId());
    }

    public TodoListTodos todoView(BigInteger id){
        return todoListTodosRepository.findById(id).get();
    }

    public void write(BigInteger userId, TodoListTodos todo) {
            TodoList todoList = todoListRepository.findByOwnerId(userId);
            if (todoList == null){
                todo.setTodoListId(BigInteger.valueOf(4));
            }

            else {
                todo.setTodoListId(todoList.getId());
            }
            todoListTodosRepository.save(todo);
    }
}
