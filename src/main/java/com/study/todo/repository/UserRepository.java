package com.study.todo.repository;

import com.study.todo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.Optional;

@Repository //DB Entity 입력 수정 삭제 조회
public interface UserRepository extends JpaRepository<User, BigInteger> {//Entity , id의 타입

    Optional<User> findByUserId (String userId);
    Optional<User> findByNickname (String nickname);
}