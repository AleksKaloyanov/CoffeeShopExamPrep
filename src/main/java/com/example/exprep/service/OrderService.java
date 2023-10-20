package com.example.exprep.service;

import com.example.exprep.model.binding.OrderAddBindingModel;
import com.example.exprep.model.service.OrderServiceModel;
import com.example.exprep.model.view.OrderViewModel;

import java.util.List;

public interface OrderService {
    void addOrder(OrderServiceModel orderServiceModel);

    List<OrderViewModel> findAllOrderByPriceDesc();

    void readyOrder(Long id);
}
