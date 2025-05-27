package com.example.demo.cart.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.cart.entity.Cart;

public interface CartRepository extends JpaRepository<Cart, Integer> {

	// 특정 회원의 장바구니에 해당 책이 존재하는지 확인
	Optional<Cart> findByMemberMemberNoAndBookBookNo(int memberNo, int bookNo);
	
	// 특정 회원의 장바구니 전체 조회
	List<Cart> findByMemberMemberNo(int memberNo);
		
}
