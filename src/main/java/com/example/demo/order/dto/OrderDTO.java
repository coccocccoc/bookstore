package com.example.demo.order.dto;

import java.time.LocalDateTime;
import java.util.List;

import com.example.demo.member.entity.Member;

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
public class OrderDTO {

//	int orderNo; // 주문번호
	
	List<OrderItemDTO> orderItems; // 주문 상세 리스트
	
	String name; // 주문자 이름
	
	String address; // 주소
	
	String phoneNumber; // 전화번호
		
//	LocalDateTime orderDate; // 주문일시
	
	int totalPrice; // 총 상품 금액
	
}
