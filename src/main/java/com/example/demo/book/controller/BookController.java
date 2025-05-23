package com.example.demo.book.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.book.dto.BookDTO;
import com.example.demo.book.service.BookService;
import com.example.demo.book.util.FileUtil;

@Controller
@RequestMapping("/bookstore")
public class BookController {
	
	@Autowired
	BookService service;
	
	@Autowired
	FileUtil fileUtil;
	
	// 메인 화면을 반환
	@GetMapping("/main")
	public String main(Model model) {
	    List<String> categoryList = List.of("소설", "시/에세이", "인문", "가정/육아", "요리", "건강");
	    model.addAttribute("categoryList", categoryList);
	    return "bookstore/main";
	}

	// 도서 목록 화면을 반환
	@GetMapping("/book-category")
	public void category(@RequestParam("category") String category, Model model) {
	    List<BookDTO> filteredList = service.getBookList()
	        .stream()
	        .filter(book -> category.equals(book.getCategory()))
	        .collect(Collectors.toList());

	    List<String> categoryList = List.of("소설", "시/에세이", "인문", "가정/육아", "요리", "건강");

	    model.addAttribute("list", filteredList);
	    model.addAttribute("categoryList", categoryList);
	    model.addAttribute("categoryName", category);
	}
	
	// 도서 상세 화면을 반환
	@GetMapping("/book-detail")
	public void detail(@RequestParam("bookNo") int bookNo, Model model) {
		BookDTO dto = service.findBookById(bookNo);
		model.addAttribute("dto", dto);
	}
	
	// 수정 화면을 반환
	@GetMapping("/book-update")
	public void update(@RequestParam("bookNo") int bookNo, Model model) {
		BookDTO dto = service.findBookById(bookNo);
		model.addAttribute("dto", dto);
	}
	
	// 수정처리
	// 수정된 정보를 수집
	@PostMapping("/book-update")
	public String updateBook(@ModelAttribute BookDTO dto, 
							 RedirectAttributes redirectAttributes) {
		
		MultipartFile file = dto.getUploadFile();
		
		if (file != null && !file.isEmpty()) {
			// 새 파일이 존재하면 업로드
	        String fileName = fileUtil.fileUpload(file);
	        dto.setImgFileName(fileName);
	    } else {
			// 새 파일이 존재하지 않으면 기존 파일 유지
			BookDTO bookDto = service.findBookById(dto.getBookNo());
	        dto.setImgFileName(bookDto.getImgFileName());
		}
			
		service.updateBook(dto);
		redirectAttributes.addAttribute("bookNo", dto.getBookNo());
		return "redirect:/bookstore/book-detail";
	}
	
	// 삭제처리
	@PostMapping("/book-delete")
	public String delete(@RequestParam("bookNo") int bookNo, RedirectAttributes redirectAttributes) {
	    String deletedCategory = service.findBookById(bookNo).getCategory(); // 삭제 전 카테고리 기억
	    service.deleteBook(bookNo);
	    redirectAttributes.addAttribute("category", deletedCategory); // 목록 복귀 시 다시 필터링
	    return "redirect:/bookstore/book-category";
	}
	
	// 등록 화면을 반환
	@GetMapping("/book-add")
	public void add() {
	}
	
	// 등록처리
	@PostMapping("/book-add")
	public String addBook(BookDTO dto, RedirectAttributes redirectAttributes) {
		int newNo = service.registerBook(dto);
		redirectAttributes.addFlashAttribute("newNo", newNo);
		redirectAttributes.addAttribute("category", dto.getCategory());
		return "redirect:/bookstore/book-category";
	}
	

	
	
}
