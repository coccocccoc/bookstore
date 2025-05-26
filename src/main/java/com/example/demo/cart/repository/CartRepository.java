package com.example.demo.cart.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.cart.entity.Cart;

public interface CartRepository extends JpaRepository<Cart, Integer> {

	// 장바구니에서 bookNo로 장바구니 항목 조회
	Optional<Cart> findByBookBookNo(int bookNo);
}
