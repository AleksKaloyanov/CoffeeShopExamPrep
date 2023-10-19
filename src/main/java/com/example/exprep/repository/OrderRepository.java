package com.example.exprep.repository;

import com.example.exprep.model.entity.OrdersEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<OrdersEntity,Long> {
}
