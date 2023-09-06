package com.igor.boot.fullstackApp.service;

import com.igor.boot.fullstackApp.entity.Orders;
import java.util.List;

public interface OrderService {
    List<Orders> getAllOrders();

    Orders saveOrder(Orders orders);

    Orders getOrder(int id);

    void updateOrder(Orders existingOrder);

    void deleteOrder(int id);
}
