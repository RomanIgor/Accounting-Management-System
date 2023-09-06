package com.igor.boot.fullstackApp.repository;

import com.igor.boot.fullstackApp.entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface OrdersRepository extends JpaRepository<Orders,Integer> {

    List<Orders> findOrderById(int id);
}
