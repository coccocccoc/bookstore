package com.example.demo.cart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.cart.service.CartService;

@Controller
@RequestMapping("/bookstore")
public class CartController {
	
	@Autowired
	CartService cartService;
	
	// 장바구니 화면 반환
	@GetMapping("/book-cart")
	public void cart() {
	}
	
	// 장바구니 목록 화면 반환
	
	
	// 수량 수정처리
	
	
	// 항목 삭제처리
	@PostMapping("/book-cart")
	public String deleteCart(@RequestParam("cartNo")int cartNo) {
		cartService.deleteCart(cartNo);
		return "redirect:/bookstore/book-cart";
	}
	
}
