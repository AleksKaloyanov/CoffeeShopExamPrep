package com.example.exprep.service.impl;

import com.example.exprep.model.binding.OrderAddBindingModel;
import com.example.exprep.model.entity.OrderEntity;
import com.example.exprep.model.service.OrderServiceModel;
import com.example.exprep.model.view.OrderViewModel;
import com.example.exprep.repository.OrderRepository;
import com.example.exprep.sec.CurrentUser;
import com.example.exprep.service.CategoryService;
import com.example.exprep.service.OrderService;
import com.example.exprep.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final ModelMapper modelMapper;
    private final UserService userService;
    private final CurrentUser currentUser;
    private final CategoryService categoryService;

    public OrderServiceImpl(OrderRepository orderRepository,
                            ModelMapper modelMapper,
                            UserService userService,
                            CurrentUser currentUser,
                            CategoryService categoryService) {
        this.orderRepository = orderRepository;
        this.modelMapper = modelMapper;
        this.userService = userService;
        this.currentUser = currentUser;
        this.categoryService = categoryService;
    }

    @Override
    public void addOrder(OrderServiceModel orderServiceModel) {
        OrderEntity order = modelMapper.map(orderServiceModel, OrderEntity.class);
        order.setEmployee(userService.findById(currentUser.getId()));
        order.setCategory(categoryService.findByCategoryNameEnum(orderServiceModel.getCategory()));

        orderRepository.save(order);
    }

    @Override
    public List<OrderViewModel> findAllOrderByPriceDesc() {
        return orderRepository
                .findAllByOrderByPriceDesc()
                .stream()
                .map(order -> modelMapper.map(order, OrderViewModel.class))
                .collect(Collectors.toList());
    }

    @Override
    public void readyOrder(Long id) {
        orderRepository.deleteById(id);
    }
}
