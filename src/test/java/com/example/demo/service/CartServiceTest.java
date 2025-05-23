package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.book.entity.Book;
import com.example.demo.book.repository.BookRepository;
import com.example.demo.cart.dto.CartDTO;
import com.example.demo.cart.service.CartService;

@SpringBootTest
public class CartServiceTest {

	@Autowired
	CartService service;
	
	@Autowired
	BookRepository bookRepository;
	
	@Test
	public void 서비스확인() {
		System.out.println("service: " + service);
	}
	
	@Test
	public void 장바구니등록() {
		Book book = bookRepository.findById(21).orElse(null);

		CartDTO dto = CartDTO.builder()
							 .book(book)
							 .quantity(2)
							 .build();
		service.addToCart(dto);
	}
	
//	@Test
//	public void 장바구니목록조회() {
//		List<CartDTO> list = service.getCartList();
//		System.out.println(list);
//	}
	
	@Test
	public void 수량수정() {
		int cartNo = 1;
		int quantity = 3;
		service.updateQuantity(cartNo, quantity);
		System.out.println(cartNo + "번 장바구니 수량 수정 완료");
	}
	
	@Test
	public void 장바구니항목삭제() {
		int cartNo = 3;
		service.deleteCart(cartNo);
		System.out.println(cartNo + "번 항목 삭제");
	}
	
	
}
