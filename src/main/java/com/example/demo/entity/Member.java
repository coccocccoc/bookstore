package com.example.demo.entity;

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
@Table(name = "tbl_member") // 실제 테이블명
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class Member {
	
	// primary key
	// auto increment
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int memberNo; // 회원 번호
	
	@Column(length = 20, nullable = false)
	String id; // 아이디
	
	@Column(length = 255, nullable = false)
	String password; // 비밀번호
	
	@Column(length = 20, nullable = false)
	String name; // 이름

	@Column(length = 255)
	String address; // 주소
	
	@Column(length = 20)
	String phoneNumber; // 전화번호
	
	@Column(length = 20, nullable = false)
	String role; // 권한(역할)
}
