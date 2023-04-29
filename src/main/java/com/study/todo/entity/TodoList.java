package com.study.todo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.OneToMany;
import lombok.Data;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class TodoList {
    @jakarta.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private BigInteger id;

    @OneToMany
    private List<Todo> todo;

    public void setId(BigInteger id) {
        this.id = id;
        this.todo = new ArrayList<>();
    }

    public BigInteger getId() {
        return id;
    }

    public void addTodo (Todo OneTodo){
        this.todo.add (OneTodo);
    }
}