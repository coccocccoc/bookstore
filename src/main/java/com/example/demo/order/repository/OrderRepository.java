package com.example.demo.order.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.order.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Integer> {

	List<Order> findByMemberMemberNo(int memberNo);
	
	// memberNo를 기준으로 주문 날짜 내림차순 정렬
    List<Order> findByMemberMemberNoOrderByOrderDateDesc(int memberNo);
	
}
