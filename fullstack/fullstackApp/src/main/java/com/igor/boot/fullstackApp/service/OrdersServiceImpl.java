package com.igor.boot.fullstackApp.service;

import com.igor.boot.fullstackApp.entity.Invoices;
import com.igor.boot.fullstackApp.entity.Orders;
import com.igor.boot.fullstackApp.repository.OrdersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class OrdersServiceImpl implements OrderService {
    @Autowired
    OrdersRepository ordersRepository;
    @Override
    public List<Orders> getAllOrders() {
        return ordersRepository.findAll();
    }

    @Override
    public Orders saveOrder(Orders orders) {
        return ordersRepository.save(orders);
    }

    @Override
    public Orders getOrder(int id) {
        return ordersRepository.findById(id).get();
    }

    @Override
    public void updateOrder(Orders orders) {
        if (ordersRepository.existsById(orders.getId())) {
           ordersRepository.save(orders);
        }
    }

    @Override
    public void deleteOrder(int id) {
        ordersRepository.deleteById(id);

    }
}
