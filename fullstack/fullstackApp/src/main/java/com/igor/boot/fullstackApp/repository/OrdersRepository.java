package com.igor.boot.fullstackApp.repository;

import com.igor.boot.fullstackApp.entity.Invoices;
import com.igor.boot.fullstackApp.entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrdersRepository extends JpaRepository<Orders,Integer> {

    List<Orders> findOrderById(int id);
}
