package com.study.todo.service;

import com.study.todo.entity.Todo;
import com.study.todo.repository.TodoRepository;
import org.springframework.stereotype.Service;
import java.math.BigInteger;
import java.util.List;

@Service
public class TodoService {

    private final TodoRepository todoRepository;
    public TodoService (TodoRepository todoRepository){
        this.todoRepository = todoRepository;
    }

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
