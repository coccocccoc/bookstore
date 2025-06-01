package com.example.demo.cart.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.cart.dto.CartDTO;
import com.example.demo.cart.entity.Cart;

public interface CartService {
	
	// 장바구니에 도서 추가
	void addToCart(CartDTO cartDto);
	
	// 장바구니 목록 조회
	List<CartDTO> getCartList();
	
	// 수량 변경
	void updateQuantity(int cartNo, int quantity);
	
	// 장바구니 항목 삭제
	void deleteCart(int cartNo);
	
	// memberNo로 장바구니 조회
	List<CartDTO> getCartListByMember(int memberNo);
	
	// DTO -> Entity
	default Cart toCartEntity(CartDTO dto) {
		Cart cart = Cart.builder()
						.cartNo(dto.getCartNo())
						.book(dto.getBook())
						.member(dto.getMember())
						.quantity(dto.getQuantity())
						.build();
		return cart;
	}
	
	// Entity -> DTO
	default CartDTO toCartDTO(Cart entity) {
		CartDTO dto = CartDTO.builder()
							 .cartNo(entity.getCartNo())
							 .book(entity.getBook())
							 .member(entity.getMember())
							 .quantity(entity.getQuantity())
							 .build();
		return dto;
	}

}
