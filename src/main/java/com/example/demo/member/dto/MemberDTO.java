package com.example.demo.member.dto;

import java.time.LocalDateTime;

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
public class MemberDTO {

	int memberNo; // 회원 번호
	
	String id; // 아이디
	
	String password; // 비밀번호
	
	String name; // 이름
	
	String address; // 주소
	
	String phoneNumber; // 전화번호
	
	String role; // 권한(역할)
	
}
