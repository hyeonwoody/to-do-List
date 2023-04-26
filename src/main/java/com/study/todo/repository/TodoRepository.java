package com.study.todo.repository;

import com.study.todo.entity.Todo;
import jakarta.persistence.Table;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;

@Repository //DB Entity 입력 수정 삭제 조회
public interface TodoRepository extends JpaRepository<Todo, BigInteger> {//Entity , id의 타입

}
