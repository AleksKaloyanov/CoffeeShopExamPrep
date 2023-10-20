package com.example.exprep.repository;

import com.example.exprep.model.entity.UserEntity;
import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity,Long> {
    Optional<UserEntity> findByUsernameAndPassword(String username, String password);

    @Query("select u from UserEntity u order by size(u.orders) desc ")
    List<UserEntity> findAllByOrdersCountOrderByDesc();
}
