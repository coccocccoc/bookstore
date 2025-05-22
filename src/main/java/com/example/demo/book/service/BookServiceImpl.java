package com.example.demo.book.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.book.dto.BookDTO;
import com.example.demo.book.entity.Book;
import com.example.demo.book.repository.BookRepository;
import com.example.demo.book.util.FileUtil;


@Service
public class BookServiceImpl implements BookService {
	
	@Autowired
	BookRepository repository;
	
	@Autowired
	FileUtil util;

	// 도서 등록 메소드
	// 테이블에 새로운 도서를 등록하고 등록한 도서 번호를 반환
	@Override
	public int registerBook(BookDTO bookDto) {
		Book entity = toBookEntity(bookDto);
		
		String filename = util.fileUpload(bookDto.getUploadFile());
		entity.setImgFilename(filename);
		
		repository.save(entity);
		int newNo = entity.getBookNo();
		
		return newNo;
	}

	// 도서 목록 조회 메소드
	@Override
	public List<BookDTO> getBookList() {
		List<Book> list = repository.findAll();
		List<BookDTO> dtoList = null;
		dtoList = list.stream()
						.map(entity -> toBookDTO(entity))
						.collect(Collectors.toList());
		return dtoList;
	}

	// 도서 단건 조회 메소드
	@Override
	public BookDTO findBookById(int bookNo) {
		Optional<Book> optional = repository.findById(bookNo);
		if(optional.isPresent()) {
			Book book = optional.get();
			BookDTO dto = toBookDTO(book);
			return dto;
		}
		return null;
	}

	// 도서 수정 메소드
	@Override
	public void updateBook(BookDTO bookDto) {
		int no = bookDto.getBookNo();
		Optional<Book> optional = repository.findById(no);
		if(optional.isPresent()) {
			Book book = optional.get();
			book.setTitle(bookDto.getTitle());
			book.setWriter(bookDto.getWriter());
			book.setPublisher(bookDto.getPublisher());
			book.setPrice(bookDto.getPrice());
			book.setCategory(bookDto.getCategory());
			
			// 이미지 파일명이 존재할 때만 수정
			// 존재하지 않으면 기존 이미지 유지
			if (bookDto.getImgFileName() != null && !bookDto.getImgFileName().isEmpty()) {
				book.setImgFilename(bookDto.getImgFileName());
			}

			repository.save(book);
		}
	}

	// 도서 삭제 메소드
	@Override
	public void deleteBook(int bookNo) {
		Optional<Book> optional = repository.findById(bookNo);
		if(optional.isPresent()) {
			repository.deleteById(bookNo);
		}
		
	}

}
