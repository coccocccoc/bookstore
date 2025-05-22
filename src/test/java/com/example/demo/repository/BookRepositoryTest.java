package com.example.demo.repository;

import java.util.List;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.book.entity.Book;
import com.example.demo.book.repository.BookRepository;

@SpringBootTest
public class BookRepositoryTest {

	@Autowired
	BookRepository repository;
	
	@Test
	public void 리파지토리확인() {
		System.out.println("repository: " + repository);
	}
	
	@Test
	public void 도서등록() {
		
		Book book1 = Book.builder()
						.title("시프트")
						.writer("조예은")
						.publisher("북다")
						.price(16800)
						.category("소설")
						.build();
		repository.save(book1);
		
	}
	
	@Test
	public void 도서목록조회() {
		List<Book> list = repository.findAll();
		System.out.println(list);
	}
	
	@Test
	public void 도서단건조회() {
		Optional<Book> optional = repository.findById(1);
		
		if(optional.isPresent()) {
			Book book = optional.get();
			System.out.println(book);
		}
	}
	
	@Test
	public void 도서정보수정() {
		Optional<Book> optional = repository.findById(1);
		
		if(optional.isPresent()) {
			Book book = optional.get();
			book.setPublisher("문학동네");
			repository.save(book);
		}
	}
	
	@Test
	public void 도서삭제() {
		repository.deleteById(null);
	}
	
}
