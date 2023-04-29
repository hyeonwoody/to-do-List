package com.study.todo.entity;

import jakarta.persistence.*;

import java.sql.Timestamp;

import lombok.Data;



import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class User {
    @jakarta.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private BigInteger id;
    private String userId;
    private String password;
    private String nickname;

    private String profileURL;
    private Timestamp updatedAt;
    private boolean loggedIn;

    @OneToMany
    private List<TodoList> myTodoLists;

    @OneToMany
    private List<TodoList> sharedTodoLists;

    public User () {
        this.myTodoLists = new ArrayList<>();
        this.sharedTodoLists = new ArrayList<>();

    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public BigInteger getId() {
        return id;
    }

    public void addTodoList(TodoList todoList) {
        this.myTodoLists.add(todoList);
    }

    public void addHWTodoList (TodoList todoList){

        this.sharedTodoLists.add (todoList);
        System.out.println("완성");
    }
}