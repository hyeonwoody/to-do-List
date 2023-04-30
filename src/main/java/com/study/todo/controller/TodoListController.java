package com.study.todo.controller;

import com.study.todo.entity.TodoList;
import com.study.todo.entity.TodoListTodos;
import com.study.todo.entity.User;
import com.study.todo.service.TodoListTodosService;
import com.study.todo.service.TodoService;

import com.study.todo.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Optional;


@Controller //브라우저와 통신
@RequestMapping("/todoList")
public class TodoListController {

    private final UserService userService;
    private final TodoListTodosService todoListTodosService;
    public TodoListController (UserService userService, TodoListTodosService todoListTodosService){
        this.userService = userService;
        this.todoListTodosService = todoListTodosService;
    }

    @GetMapping("/show-memo") //localhost:12000/showMemo?id=24
    public String showMemo (Model model, BigInteger id){
        model.addAttribute("todo", todoListTodosService.todoView(id));

        return "showMemo";
    }

    @PostMapping("/write-todo")
    public String writeTodo (HttpSession session, TodoListTodos todo){//String title, String memo //@RequestParam("title") String title, @RequestParam("memo") String memo
        System.out.println("여기까지는 왔다");
        System.out.println("유저아이디"+session.getAttribute("id"));
        System.out.println("투두zzzzz"+todo);
        Optional<User> user = userService.findById((BigInteger)session.getAttribute("id"));

        System.out.println("유저 찾았냐"+user);
        if (user.isPresent()){
            /*
            MyTodoLists는 List이므로 추후 다중 TodoList 구현
            현재는 하나로만 사용.
             */
            todoListTodosService.write(user.get().getId(), todo);
        }
        else {


            todoListTodosService.write(BigInteger.valueOf(4),todo);
        }


        //System.out.println("투두zxcvxcvxczzzz"+userTodoList);
        //todoListTodosService.write(todo);





        //todoListService.write(todo, (BigInteger) session.getAttribute("id"));
        //todoListService.write(todo);//data Base 저장


        //System.out.println(todo);
        return "redirect:/main";
    }

}
