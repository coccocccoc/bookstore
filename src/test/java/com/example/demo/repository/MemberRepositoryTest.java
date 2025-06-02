package com.example.demo.repository;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.member.entity.Member;
import com.example.demo.member.repository.MemberRepository;

@SpringBootTest
public class MemberRepositoryTest {

	@Autowired
	MemberRepository repository;
	
	@Test
	public void 리파지토리확인() {
		System.out.println("repository: " + repository);
	}
	
	@Test
	public void 회원등록() {
		Member member1 = Member.builder()
								.username("abc123")
								.password("1234")
								.name("둘리")
								.address("대전시 유성구 상대복용로29번길 51 대전아이파크시티2단지 205동 601호")
								.phoneNumber("010-1111-2222")
								.role("user")
								.build();
		repository.save(member1);
		
		Member member2 = Member.builder()
								.username("admin1")
								.password("1234")
								.name("짱구")
								.address(null)
								.phoneNumber(null)
								.role("admin")
								.build();
		repository.save(member2);
		
		Member member3 = Member.builder()
								.username("yuri123")
								.password("1234")
								.name("유리")
								.address("대구광역시 수성구")
								.phoneNumber("010-3333-4444")
								.role("user")
								.build();	
		repository.save(member3);
	}
	
	@Test
	public void 회원목록조회() {
		List<Member> list = repository.findAll();
		System.out.println(list);
	}
	
	@Test
	public void 회원단건조회() {
		Optional<Member> optional = repository.findById(1);
		
		if(optional.isPresent()) {
			Member member = optional.get();
			System.out.println(member);
		}
	}
	
	@Test
	public void 회원정보수정() {
		Optional<Member> optional = repository.findById(1);
		
		if(optional.isPresent()) {
			Member member = optional.get();
			member.setAddress("인천 남동구 문화로 161, 대우재한신휴플러스아파트 103동 1014호");
			repository.save(member);
		}
	}
	
	@Test
	public void 회원삭제() {
		repository.deleteById(3);
	}
	
}
