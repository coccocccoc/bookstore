package com.example.demo.order.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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


	// 장바구니로부터 주문 저장
	@Override
    public void saveOrderFromCart(int memberNo) {
        Member member = memberRepository.findById(memberNo).orElseThrow();
        List<Cart> cartList = cartRepository.findByMemberMemberNo(memberNo);

        int totalPrice = calculateTotalPrice(cartList);

        Order order = Order.builder()
                .member(member)
                .totalPrice(totalPrice)
                .build();

        List<OrderItem> orderItems = new ArrayList<>();
        for (Cart cart : cartList) {
            OrderItem item = OrderItem.builder()
                    .order(order)
//                    .bookNo(cart.getBook().getBookNo())
                    .quantity(cart.getQuantity())
                    .build();
            orderItems.add(item);
        }
        order.setOrderItems(orderItems);

        orderRepository.save(order); // cascade로 OrderItem 자동 저장

//        cartRepository.deleteAll(cartList); // 장바구니 비우기
        
        cartRepository.deleteByMember(member);
    }

    // totalPrice 계산
    @Override
    public int calculateTotalPrice(List<Cart> cartList) {
        int totalPrice = 0;
        for (Cart cart : cartList) {
            int price = (int) (cart.getBook().getPrice() * 0.9);
            totalPrice = totalPrice + price * cart.getQuantity();
        }
        return totalPrice;
    }

	
	// 특정 주문에 속한 모든 주문 상세 조회 메소드
	@Override
	public List<OrderItemDTO> getOrderItemsByOrderNo(int orderNo) {
		return null;
	}
	


}
