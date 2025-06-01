package com.example.demo.member.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.member.dto.MemberDTO;
import com.example.demo.member.entity.Member;
import com.example.demo.member.repository.MemberRepository;

@Service
public class MemberServiceImpl implements MemberService{
	
	@Autowired
	MemberRepository memberRepository;

    @Override
    public void register(MemberDTO memberDTO) {
        Member member = Member.builder()
                .username(memberDTO.getUsername())
                .password(memberDTO.getPassword())
                .name(memberDTO.getName())
                .address(memberDTO.getAddress())
                .phoneNumber(memberDTO.getPhoneNumber())
                .role("USER")
                .build();

        memberRepository.save(member);
    }






}
