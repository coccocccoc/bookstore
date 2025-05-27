package com.example.demo.order.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.order.entity.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Integer>{

}
