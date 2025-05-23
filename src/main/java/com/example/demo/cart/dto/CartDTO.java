package com.example.demo.cart.dto;

import com.example.demo.book.entity.Book;

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
public class CartDTO {

	int cartNo; // 장바구니 번호
	
	Book book; // 도서
	
	int quantity; // 수량
	
}
