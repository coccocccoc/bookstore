package com.example.demo.cart.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.book.repository.BookRepository;
import com.example.demo.cart.dto.CartDTO;
import com.example.demo.cart.entity.Cart;
import com.example.demo.cart.repository.CartRepository;

@Service
public class CartServiceImpl implements CartService {
	
	@Autowired
	CartRepository cartRepository;
	
	@Autowired
	BookRepository bookRepository;

	
	// 장바구니 추가 메소드
	@Override
	public void addToCart(CartDTO cartDto) {
		Cart cart = Cart.builder()
                .book(cartDto.getBook())
                .quantity(cartDto.getQuantity())
                .build();

        cartRepository.save(cart);
	}

	// 장바구니 목록 조회 메소드
	@Override
	public List<CartDTO> getCartList() {
		List<Cart> list = cartRepository.findAll();
	    List<CartDTO> dtoList = null;
	    dtoList = list.stream()
	                  .map(entity -> toCartDTO(entity))
	                  .collect(Collectors.toList());
	    return dtoList;
	}

	// 수량 수정 메소드
	@Override
	public void updateQuantity(int cartNo, int quantity) {
		Optional<Cart> optional = cartRepository.findById(cartNo);
		if(optional.isPresent()) {
			Cart cart = optional.get();
			cart.setQuantity(quantity);
			cartRepository.save(cart);
		}
	}

	// 장바구니 항목 삭제 메소드
	@Override
	public void deleteCart(int cartNo) {
		Optional<Cart> optional = cartRepository.findById(cartNo);
		if(optional.isPresent()) {
			cartRepository.deleteById(cartNo);
		}
		
	}

}
