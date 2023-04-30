package com.study.todo.repository;

import com.study.todo.entity.Todo;
import com.study.todo.entity.TodoListTodos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Repository //DB Entity 입력 수정 삭제 조회
public interface TodoListTodosRepository extends JpaRepository<TodoListTodos, BigInteger> {


    List<TodoListTodos> findByTodoListId (BigInteger id);
}
