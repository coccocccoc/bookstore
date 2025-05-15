package com.example.demo.book.service;

import java.util.List;

import com.example.demo.book.dto.BookDTO;
import com.example.demo.book.entity.Book;

public interface BookService {
	
	// 도서 등록
	int registerBook(BookDTO bookDto);
	
	// 도서 정보 목록 조회
	List<BookDTO> getBookList();
	
	// 도서 정보 상세 조회
	BookDTO findBookById(int bookNo);
	
	// 도서 정보 수정
	void updateBook(BookDTO bookDto);
	
	// 도서 삭제
	void deleteBook(int bookNo);
	
	// DTO를 Entity로 바꾸는 메소드
	default Book toBookEntity(BookDTO dto) {
		Book book = Book.builder()
							.bookNo(dto.getBookNo())
							.title(dto.getTitle())
							.writer(dto.getWriter())
							.publisher(dto.getPublisher())
							.price(dto.getPrice())
							.category(dto.getCategory())
							.isbn(dto.getIsbn())
							.build();
		return book;
	}
	
	// Entity를 DTO로 바꾸는 메소드
	default BookDTO toBookDTO(Book entity) {
		BookDTO dto = BookDTO.builder()
								.bookNo(entity.getBookNo())
								.title(entity.getTitle())
								.writer(entity.getWriter())
								.publisher(entity.getPublisher())
								.price(entity.getPrice())
								.category(entity.getCategory())
								.isbn(entity.getIsbn())
								.build();
		return dto;
	}

}
