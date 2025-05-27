package com.example.demo.cart.dto;

import com.example.demo.book.entity.Book;
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
public class CartDTO {

	int cartNo; // 장바구니 번호
	
	Book book; // 도서
	
	Member member; // 회원
	
	int quantity; // 수량
	
}
