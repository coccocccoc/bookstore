package com.example.demo.service;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.book.dto.BookDTO;
import com.example.demo.book.service.BookService;

@SpringBootTest
public class BookServiceTest {

	@Autowired
	BookService service;
	
	@Test
	public void 서비스확인() {
		System.out.println("service: " + service);
	}
	
	@Test
	public void 도서등록() {
		BookDTO dto = BookDTO.builder()
								.title("건강22")
								.writer("ww")
								.publisher("pp")
								.price(15000)
								.category("건강")
								.build();
		int newNo = service.registerBook(dto);
	}
	
	@Test
	public void 도서목록조회() {
		List<BookDTO> list = service.getBookList();
		System.out.println(list);
	}
	
	@Test
	public void 도서단건조회() {
		BookDTO dto = service.findBookById(2);
		System.out.println(dto);
	}
	
	@Test
	public void 도서정보수정() {
		BookDTO dto = service.findBookById(2);
		dto.setPrice(16900);
		service.updateBook(dto);
	}
	
	@Test
	public void 도서삭제() {
		service.deleteBook(3);
	}
	
}
