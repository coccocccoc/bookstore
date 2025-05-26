package com.example.demo.book.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "tbl_book")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class Book {

	// primary key
	// auto increment 
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int bookNo; // 책 번호
	
	@Column(length = 255, nullable = false)
	String title; // 책 제목
	
	@Column(length = 20, nullable = false)
	String writer; // 저자

	@Column(length = 20, nullable = false)
	String publisher; // 출판사
	
	@Column(nullable = false)
	int price; // 가격
		
	@Column(length = 20, nullable = false)
	String category; // 카테고리
	
	String imgFilename; // 이미지파일 이름
	
}
