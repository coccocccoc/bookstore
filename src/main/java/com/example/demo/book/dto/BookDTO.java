package com.example.demo.book.dto;

import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class BookDTO {

	int bookNo; // 책 번호

	String title; // 책 제목 
	
	String writer; // 저자
	
	String publisher; // 출판사
	
	int price; // 가격
	
	String category; // 카테고리
	
	// 사용자가 업로드한 파일을 담는 객체
	MultipartFile uploadFile; 
	
	String imgFileName; // 파일 이름
		
}
