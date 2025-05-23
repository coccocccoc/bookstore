package com.example.demo.repository;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.book.entity.Book;
import com.example.demo.book.repository.BookRepository;
import com.example.demo.cart.entity.Cart;
import com.example.demo.cart.repository.CartRepository;

import jakarta.transaction.Transactional;

@SpringBootTest
public class CartRepositoryTest {

	@Autowired
	CartRepository cartRepository;
	
	@Autowired
	BookRepository bookRepository;
	
	@Test
	public void 리파지토리확인() {
		System.out.println("repository: " + cartRepository);
	}
	
	@Test
	public void 장바구니추가() {
		
		Optional<Book> optionalBook = bookRepository.findById(24);
			
		Cart cart = Cart.builder()
						.book(optionalBook.get())
						.quantity(1)
						.build();
		cartRepository.save(cart);
	}
	
	 @Test
	 @Transactional
	    public void 장바구니목록조회() {
	        List<Cart> list = cartRepository.findAll();
	        System.out.println(list);
	 }
	
	@Test
	public void 수량변경() {
		Optional<Cart> optional = cartRepository.findById(1);
		if(optional.isPresent()) {
			Cart cart = optional.get();
			cart.setQuantity(1);
			cartRepository.save(cart);
		}
	}

	@Test
	public void 장바구니항목삭제() {
		cartRepository.deleteById(2);
	}
}
