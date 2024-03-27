package com.bluehogusa.bluehog.services;

import java.util.List;

import com.bluehogusa.bluehog.domain.Order;

public interface OrderService {

    public List<Order> getOrders();

    public void updateOrderStatus(String status, String orderId);

    public void checkoutOrder(Order order);

    // public OrderDto findById(String orderId);
}