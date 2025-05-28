package com.example.demo.order.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.book.repository.BookRepository;
import com.example.demo.cart.repository.CartRepository;
import com.example.demo.member.repository.MemberRepository;
import com.example.demo.order.dto.OrderDTO;
import com.example.demo.order.dto.OrderItemDTO;
import com.example.demo.order.repository.OrderItemRepository;
import com.example.demo.order.repository.OrderRepository;

@Service
public class OrderServiceImpl implements OrderService{
	
	@Autowired
	CartRepository cartRepository;
	
	@Autowired
	BookRepository bookRepository;

	@Autowired
	MemberRepository memberRepository;
	
	@Autowired
	OrderRepository orderRepository;
	
	@Autowired
	OrderItemRepository orderItemRepository;
	

	/* Order */
	// 주문 생성 메소드
	@Override
	public OrderDTO createOrder(OrderDTO orderDTO) {
		return null;
	}

	// 회원 번호로 주문 목록 조회 메소드
	@Override
	public List<OrderDTO> getOrdersByMemberNo(int memberNo) {
		return null;
	}

	
	
	/* OrderItem */
	// 특정 주문에 속한 모든 주문 상세 조회 메소드
	@Override
	public List<OrderItemDTO> getOrderItemsByOrderNo(int orderNo) {
		return null;
	}

}
