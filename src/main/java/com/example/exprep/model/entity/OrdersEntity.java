package com.example.exprep.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jdk.jfr.Category;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "orders")
public class OrdersEntity extends BaseEntity {

    private String name;
    private String description;
    private BigDecimal price;
    private LocalDateTime orderTime;
    private CategoryEntity category;
    private UserEntity employee;

    public OrdersEntity() {
    }

    @Column(nullable = false)
    public String getName() {
        return name;
    }

    public OrdersEntity setName(String name) {
        this.name = name;
        return this;
    }

    @Column(nullable = false, columnDefinition = "TEXT")
    public String getDescription() {
        return description;
    }

    public OrdersEntity setDescription(String description) {
        this.description = description;
        return this;
    }

    @Column(nullable = false)
    public BigDecimal getPrice() {
        return price;
    }

    public OrdersEntity setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    @Column(nullable = false)
    public LocalDateTime getOrderTime() {
        return orderTime;
    }

    public OrdersEntity setOrderTime(LocalDateTime orderTime) {
        this.orderTime = orderTime;
        return this;
    }

    @ManyToOne
    public CategoryEntity getCategory() {
        return category;
    }

    public OrdersEntity setCategory(CategoryEntity category) {
        this.category = category;
        return this;
    }

    @ManyToOne
    public UserEntity getEmployee() {
        return employee;
    }

    public OrdersEntity setEmployee(UserEntity employee) {
        this.employee = employee;
        return this;
    }
}
