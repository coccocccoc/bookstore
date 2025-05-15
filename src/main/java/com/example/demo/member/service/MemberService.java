package com.example.demo.member.service;

import java.util.List;

import com.example.demo.member.dto.MemberDTO;
import com.example.demo.member.entity.Member;

public interface MemberService {
	
	// 회원 등록
	MemberDTO registerMember(MemberDTO memberDTO);
	
//	// 회원 정보 목록 조회
//	List<MemberDTO> getMemberList();
//	
//	// 회원 정보 상세 조회
//	MemberDTO findMemberById(int memberNo);
//	
//	// 회원 정보 수정
//	void updateMember(MemberDTO memberDTO);
//	
//	// 회원 삭제
//	void deleteMember(int memberNo);
	
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
