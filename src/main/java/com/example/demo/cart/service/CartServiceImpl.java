package com.example.demo.cart.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.book.entity.Book;
import com.example.demo.book.repository.BookRepository;
import com.example.demo.cart.dto.CartDTO;
import com.example.demo.cart.entity.Cart;
import com.example.demo.cart.repository.CartRepository;
import com.example.demo.member.entity.Member;
import com.example.demo.member.repository.MemberRepository;

@Service
public class CartServiceImpl implements CartService {
	
	@Autowired
	CartRepository cartRepository;
	
	@Autowired
	BookRepository bookRepository;

	@Autowired
	MemberRepository memberRepository;
	
	// 장바구니 추가 메소드
	@Override
	public void addToCart(CartDTO cartDto) {
		
		if (cartDto.getBook() == null || cartDto.getBook().getBookNo() == 0) {
	        throw new IllegalArgumentException("도서 정보가 누락되었습니다.");
	    }
		
		int bookNo = cartDto.getBook().getBookNo();
		
		Book book = bookRepository.findById(bookNo)
                .orElseThrow(() -> new IllegalArgumentException("해당 도서를 찾을 수 없습니다: " + bookNo));
		
		// 회원 (memberNo = 1)
		Member member = memberRepository.findById(1)
				.orElseThrow(() -> new IllegalArgumentException("회원을 찾을 수 없습니다."));

	    // 동일한 도서가 이미 장바구니에 있는지 확인	
	    Optional<Cart> optional = cartRepository.findByMemberMemberNoAndBookBookNo(member.getMemberNo(), bookNo);

	    if (optional.isPresent()) {
	        // 장바구니에 이미 존재할 경우 수량 증가
	        Cart cart = optional.get();
	        cart.setQuantity(cart.getQuantity() + cartDto.getQuantity());
	        cartRepository.save(cart);
	    } else {
	        // 장바구니에 없으면 새로 추가
	        Cart newCart = Cart.builder()
	                .book(book)
	                .member(member)
	                .quantity(cartDto.getQuantity())
	                .build();
	        cartRepository.save(newCart);
	    }
	}

	// 장바구니 목록 조회 메소드
	@Override
	public List<CartDTO> getCartList() {
		
		Member member = memberRepository.findById(1)
	            .orElseThrow(() -> new IllegalArgumentException("회원을 찾을 수 없습니다."));
		
		List<Cart> list = cartRepository.findByMemberMemberNo(member.getMemberNo());
		return list.stream()
	               .map(this::toCartDTO)
	               .collect(Collectors.toList());
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
