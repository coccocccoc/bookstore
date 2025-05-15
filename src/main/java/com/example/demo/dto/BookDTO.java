package com.example.demo.dto;

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
	
	String isbn; // 국제표준도서번호
	
}
