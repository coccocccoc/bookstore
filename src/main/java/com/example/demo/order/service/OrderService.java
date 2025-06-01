package com.example.demo.order.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.example.demo.cart.entity.Cart;
import com.example.demo.member.entity.Member;
import com.example.demo.order.dto.OrderDTO;
import com.example.demo.order.dto.OrderItemDTO;
import com.example.demo.order.entity.Order;
import com.example.demo.order.entity.OrderItem;

public interface OrderService {

	/* Order */
       
    // 주문 저장
	void saveOrderFromCart(int memberNo);	
	
    // totalPrice 계산
    int calculateTotalPrice(List<Cart> cartList);
    
    // 주문 조회
    List<Order> findOrdersByMemberNo(int memberNo);
    
    // 특
    Optional<Order> findOrderByOrderNo(int orderNo);
    

    // DTO -> Entity
    default Order toOrderEntity() {
    	Order order = Order.builder()
    						.orderNo(0)
    						.orderItems(null)
    						.member(null)
    						.orderDate(null)
    						.totalPrice(0)
    						.build();
    	return order;
    }
	
    // Entity -> DTO
    default OrderDTO toOrderDTO(Order entity) {
    	OrderDTO dto = OrderDTO.builder()
//    							.orderNo(entity.getOrderNo())
//    							.member(entity.getMember())
//    							.orderDate(entity.getOrderDate())
    							.name(entity.getMember().getName())
    							.address(entity.getMember().getAddress())
    							.phoneNumber(entity.getMember().getPhoneNumber())
    							.totalPrice(entity.getTotalPrice())
    							.build();
    	
    	// 
    	List<OrderItemDTO> orderItemDTOs = entity.getOrderItems().stream()
    											 .map(this::toOrderItemDTO)
    											 .collect(Collectors.toList());
    	dto.setOrderItems(orderItemDTOs);
    	
    	return dto;
    }
    
	
	/* OrderItem */	
    
    // DTO -> Entity
    default OrderItem toOrderItemEntity(OrderItemDTO dto) {
        OrderItem orderItem = OrderItem.builder()
//				                        .order(dto.getOrder())
//				                        .bookNo(dto.getBookNo())
//				                        .count(dto.getCount())
//				                        .cart(dto.getCart())
				                        .build();
        return orderItem;
    }
    
    // Entity -> DTO
    default OrderItemDTO toOrderItemDTO(OrderItem entity) {
        OrderItemDTO dto = OrderItemDTO.builder()
        							
//			                           .orderItemNo(entity.getOrderItemNo())
//			                           .bookName(entity.getBook().getTitle())
//			                           .bookNo(entity.getBookNo())
//			                           .count(entity.getCount())
			                           .build();
        return dto;
    }
    
}
