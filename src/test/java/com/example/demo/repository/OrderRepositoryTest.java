package com.example.demo.repository;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.cart.entity.Cart;
import com.example.demo.cart.repository.CartRepository;
import com.example.demo.member.entity.Member;
import com.example.demo.member.repository.MemberRepository;
import com.example.demo.order.entity.Order;
import com.example.demo.order.repository.OrderItemRepository;
import com.example.demo.order.repository.OrderRepository;

import jakarta.transaction.Transactional;

@SpringBootTest
public class OrderRepositoryTest {

	@Autowired
	OrderRepository orderRepository;
	
	@Autowired
	OrderItemRepository orderItemRepository;
	
	@Autowired
	MemberRepository memberRepository;
	
	@Autowired
	CartRepository cartRepository;
	
	
	@Test
	@Transactional
	public void 주문등록(){
		
		// 회원, 장바구니 
		int memberNo = 1; 
		Optional<Member> member = memberRepository.findById(memberNo);
		Optional<Cart> cart = cartRepository.findByMemberMemberNo(memberNo);
		
		Order order = Order.builder()
							.member(member.get())
							.totalPrice(0)
							.build();
		
		// 주문 상세
	}
	
}
