package com.example.demo.book.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.book.dto.BookDTO;
import com.example.demo.book.service.BookService;

@Controller
@RequestMapping("/bookstore")
public class BookController {
	
	@Autowired
	BookService service;
	
	// 메인 화면을 반환
	@GetMapping("/main")
	public void main() {
		// bookstore 폴더 아래 main.html 파일
	}

	// 도서 목록 화면을 반환(소설)
	@GetMapping("/book-category")
	public void category(Model model) {
	    List<BookDTO> list = service.getBookList();
	    model.addAttribute("list", list);
	}
	
	// 도서 상세 화면을 반환
	@GetMapping("/book-detail")
	public void detail(@RequestParam("bookNo") int bookNo, Model model) {
		BookDTO dto = service.findBookById(bookNo);
		model.addAttribute("dto", dto);
	}
	
	// 수정 화면을 반환
	
}
