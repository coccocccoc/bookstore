package com.example.demo.order.service;

import java.util.List;
import java.util.stream.Collectors;

import com.example.demo.cart.entity.Cart;
import com.example.demo.member.entity.Member;
import com.example.demo.order.dto.OrderDTO;
import com.example.demo.order.dto.OrderItemDTO;
import com.example.demo.order.entity.Order;
import com.example.demo.order.entity.OrderItem;

public interface OrderService {

	/* Order */
   
    // 회원 번호로 주문 목록 조회
//    List<OrderDTO> getOrdersByMemberNo(int memberNo);
    
    // 주문 저장
	void saveOrderFromCart(int memberNo);
	
	
    // totalPrice 계산
    int calculateTotalPrice(List<Cart> cartList);
    

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
    // 특정 주문에 속한 모든 주문 상세 조회
    List<OrderItemDTO> getOrderItemsByOrderNo(int orderNo);
    
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
