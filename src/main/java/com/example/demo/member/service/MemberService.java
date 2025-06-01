package com.example.demo.member.service;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.example.demo.member.dto.MemberDTO;
import com.example.demo.member.entity.Member;

public interface MemberService extends UserDetailsService{
	
	// 회원 등록
	void register(MemberDTO memberDTO);
	

	// DTO를 Entity로 바꾸는 메소드
	default Member toMemberEntity(MemberDTO dto) {
		Member member = Member.builder()
								.memberNo(dto.getMemberNo())
								.id(dto.getId())
								.password(dto.getPassword())
								.name(dto.getName())
								.address(dto.getAddress())
								.phoneNumber(dto.getPhoneNumber())
								.role(dto.getRole())
								.build();
		return member;
	}
	
	// Entity를 DTO로 바꾸는 메소드
	default MemberDTO toMemberDTO(Member entity) {
		MemberDTO dto = MemberDTO.builder()
									.memberNo(entity.getMemberNo())
									.id(entity.getId())
									.password(entity.getPassword())
									.name(entity.getName())
									.address(entity.getAddress())
									.phoneNumber(entity.getPhoneNumber())
									.role(entity.getRole())
									.build();
		return dto;
		
	}

}
