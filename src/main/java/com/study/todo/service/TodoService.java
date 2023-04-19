package com.study.todo.service;

import com.study.todo.entity.Todo;
import com.study.todo.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.math.BigInteger;
import java.util.List;

@Service
public class TodoService {

    @Autowired //Dependency Injection  Todo todo = newTodo (); todo.setTodo(todo)
    private TodoRepository todoRepository;

    public void write(Todo todo){
        todoRepository.save(todo);
    }

    public List<Todo> todoList(){
        return todoRepository.findAll();
    }

    public Todo todoView(BigInteger id){

        return todoRepository.findById(id).get();
    }
}
