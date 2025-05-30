//package com.example.demo.repository;
//
//import java.util.List;
//import java.util.Optional;
//
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.annotation.Rollback;
//
//import com.example.demo.cart.entity.Cart;
//import com.example.demo.cart.repository.CartRepository;
//import com.example.demo.member.entity.Member;
//import com.example.demo.member.repository.MemberRepository;
//import com.example.demo.order.entity.Order;
//import com.example.demo.order.entity.OrderItem;
//import com.example.demo.order.repository.OrderItemRepository;
//import com.example.demo.order.repository.OrderRepository;
//
//import jakarta.transaction.Transactional;
//
//@SpringBootTest
//public class OrderRepositoryTest {
//
//	@Autowired
//	OrderRepository orderRepository;
//	
//	@Autowired
//	OrderItemRepository orderItemRepository;
//	
//	@Autowired
//	MemberRepository memberRepository;
//	
//	@Autowired
//	CartRepository cartRepository;
//	
//	
//	@Test
//	@Transactional
//	@Rollback(false)
//	public void 주문등록(){
//		
//		// 회원, 장바구니, 주문 생성
//		int memberNo = 1; 
//		Optional<Member> member = memberRepository.findById(memberNo);
//		List<Cart> cart = cartRepository.findByMemberMemberNo(memberNo);
//		
//		// totalPrice 계산
//		int totalPrice = cart.stream()
//			                 .mapToInt(c -> c.getBook().getPrice() * c.getQuantity())
//			                 .sum();
//		
//		Order order = Order.builder()
//							.member(member.get())
//							.totalPrice(totalPrice)
//							.build();
//		
//		// 주문 상세 생성
//		List<OrderItem> orderItems = cart.stream()
//			    .map(c -> OrderItem.builder()
//			                       .order(order)
//			                       .cart(c)
//			                       .build())
//			    .toList();
//		
//		order.setOrderItems(orderItems);
//		
//		// 저장
//		orderRepository.save(order);
//	}
//	
//}
