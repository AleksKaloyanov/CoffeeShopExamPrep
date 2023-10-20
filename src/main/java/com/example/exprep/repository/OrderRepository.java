package com.example.exprep.repository;

import com.example.exprep.model.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<OrderEntity,Long> {
    List<OrderEntity> findAllByOrderByPriceDesc();
}
