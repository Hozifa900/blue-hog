package com.bluehogusa.bluehog.services.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bluehogusa.bluehog.domain.Order;
import com.bluehogusa.bluehog.repository.OrderRepository;
import com.bluehogusa.bluehog.services.OrderService;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderRepository orderRepository;

    @Override
    public List<Order> getOrders() {
        return orderRepository.findAll();
    }

    @Override
    public void updateOrderStatus(String status, String orderId) {
        Order order = orderRepository.findOrderById(orderId);
        if (order != null) {
            order.setStatus(status);
            orderRepository.save(order);

        } else {
            throw new RuntimeException("Order not found");
        }
    }

    @Override
    public void checkoutOrder(Order order) {
        orderRepository.save(order);
    }

}
