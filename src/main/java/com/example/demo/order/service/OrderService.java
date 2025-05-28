package com.example.demo.order.service;

import java.util.List;
import java.util.stream.Collectors;

import com.example.demo.order.dto.OrderDTO;
import com.example.demo.order.dto.OrderItemDTO;
import com.example.demo.order.entity.Order;
import com.example.demo.order.entity.OrderItem;

public interface OrderService {

	/* Order */
	// 주문 생성
	OrderDTO createOrder(OrderDTO orderDTO);
    
    // 회원 번호로 주문 목록 조회
    List<OrderDTO> getOrdersByMemberNo(int memberNo);
    
    // DTO -> Entity
    default Order toOrderEntity(OrderDTO dto) {
    	Order order =  Order.builder()
			                .orderNo(dto.getOrderNo())
			                .member(dto.getMember())
			                .orderDate(dto.getOrderDate())
			                .totalPrice(dto.getTotalPrice())
			                .build();
    	
    	List<OrderItem> orderItems = dto.getOrderItems().stream()
    									.map(itemDTO -> { 
    										OrderItem item = toOrderItemEntity(itemDTO);
    	                                    item.setOrder(order);
    	                                    return item;
    									})
    									.collect(Collectors.toList());
    	order.setOrderItems(orderItems);
    	
    	return order;
    }
	
    // Entity -> DTO
    default OrderDTO toOrderDTO(Order entity) {
    	OrderDTO dto = OrderDTO.builder()
    							.orderNo(entity.getOrderNo())
    							.member(entity.getMember())
    							.orderDate(entity.getOrderDate())
    							.totalPrice(entity.getTotalPrice())
    							.build();
    	
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
				                        .orderItemNo(dto.getOrderItemNo())
				                        .order(dto.getOrder())
				                        .cart(dto.getCart())
				                        .build();
        return orderItem;
    }
    
    // Entity -> DTO
    default OrderItemDTO toOrderItemDTO(OrderItem entity) {
        OrderItemDTO dto = OrderItemDTO.builder()
			                           .orderItemNo(entity.getOrderItemNo())
			                           .order(entity.getOrder())
			                           .cart(entity.getCart())
			                           .build();
        return dto;
    }
    
}
