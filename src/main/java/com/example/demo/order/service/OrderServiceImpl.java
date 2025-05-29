package com.example.demo.order.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.book.repository.BookRepository;
import com.example.demo.cart.entity.Cart;
import com.example.demo.cart.repository.CartRepository;
import com.example.demo.member.entity.Member;
import com.example.demo.member.repository.MemberRepository;
import com.example.demo.order.dto.OrderDTO;
import com.example.demo.order.dto.OrderItemDTO;
import com.example.demo.order.entity.Order;
import com.example.demo.order.entity.OrderItem;
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
		
		// 회원 (memberNo = 1)
		int memberNo = 1;
		Member member = memberRepository.findById(memberNo)
										.orElseThrow(() -> new IllegalArgumentException("회원을 찾을 수 없습니다."));
		
		LocalDateTime orderDate = LocalDateTime.now();
		
		// 주문 객체 생성
		Order order = Order.builder()
							.member(member)
							.orderDate(orderDate)
							.totalPrice(0)
							.build();
		orderRepository.save(order);
		
		// 장바구니 조회
		List<Cart> cartList = cartRepository.findByMemberMemberNo(memberNo);
		if(cartList.isEmpty()) {
			throw new RuntimeException("장바구니가 비어있습니다");
		}
		
		// 주문 상세 생성, totalPrice 계산
		List<OrderItem> orderItemList = new ArrayList<>();
		
		int totalPrice = 0;
		
		for (Cart cart : cartList) {
	        OrderItem orderItem = OrderItem.builder()
							                .order(order)
							                .cart(cart)
							                .build();
	        orderItemList.add(orderItem);

	        totalPrice = totalPrice + cart.getBook().getPrice() * cart.getQuantity();
	    }
		orderItemRepository.saveAll(orderItemList);
		
		// totalPrice 반영
		order.setTotalPrice(totalPrice);
		
		orderRepository.save(order); 
		
		// 장바구니 비우기
		cartRepository.deleteAll(cartList);
		
		return null;
	}
	
	// 장바구니 비우기..?
	

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
