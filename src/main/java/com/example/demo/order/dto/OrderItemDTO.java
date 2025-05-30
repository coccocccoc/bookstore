package com.example.demo.order.dto;

import com.example.demo.cart.entity.Cart;

import com.example.demo.order.entity.Order;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class OrderItemDTO {

	int orderItemNo; // 주문 상세 번호
	
//	Order order; // 주문
		
	int bookNo; // 도서 번호
	
	int quantity; // 수량
	
	// 책의 제목
	String bookName;
	
	// 책의 가격
	
	// 이미지
	
}
