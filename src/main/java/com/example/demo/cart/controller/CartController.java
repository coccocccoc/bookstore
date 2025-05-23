package com.example.demo.cart.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.cart.dto.CartDTO;
import com.example.demo.cart.service.CartService;

@Controller
@RequestMapping("/bookstore")
public class CartController {
	
	@Autowired
	CartService cartService;
	
	// 장바구니에 도서 추가
	@PostMapping("/book-detail/add")
	public String addCart(@ModelAttribute CartDTO dto) {
		cartService.addToCart(dto);
	    return "redirect:/bookstore/book-cart";
	}
	
	// 장바구니 화면 반환 (목록 조회, 총 합계 계산, 총 수량 계산)
	@GetMapping("/book-cart")
	public String cart(Model model) {
		List<CartDTO> list = cartService.getCartList();
		model.addAttribute("cartList", list);
		
		// 총 합계 계산
	    int totalPrice = 0;
	    for (CartDTO dto : list) {
	        int price = (int)(dto.getBook().getPrice() * 0.9);
	        totalPrice = totalPrice + (price * dto.getQuantity());
	    }
	    model.addAttribute("totalPrice", totalPrice);
	    
	    // 총 수량 계산
	    int totalQuantity = 0;
	    for (CartDTO dto : list) {
			totalQuantity = totalQuantity + dto.getQuantity();
		}
	    model.addAttribute("totalQuantity", totalQuantity);

	    return "bookstore/book-cart";
	}
		
	
	// 수량 수정처리
	@PostMapping("/book-cart/update")
	public String updateQuantity(@RequestParam("cartNo")int cartNo,
								 @RequestParam("quantity") int quantity) {
		cartService.updateQuantity(cartNo, quantity);
		return "redirect:/bookstore/book-cart";
		
	}
	
	
	// 항목 삭제처리
	@PostMapping("/book-cart/delete")
	public String deleteCart(@RequestParam("cartNo")int cartNo) {
		cartService.deleteCart(cartNo);
		return "redirect:/bookstore/book-cart";
	}
	
}
