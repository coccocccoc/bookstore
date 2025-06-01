package com.example.demo.repository;

import java.util.List;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.book.entity.Book;
import com.example.demo.book.repository.BookRepository;

@SpringBootTest
public class BookRepositoryTest {

	@Autowired
	BookRepository repository;
	
	@Test
	public void 리파지토리확인() {
		System.out.println("repository: " + repository);
	}
	
	@Test
	public void 도서등록() {
		
		Book book1 = Book.builder()
						.title("시프트")
						.writer("조예은")
						.publisher("북다")
						.price(16800)
						.category("소설")
						.imgFilename("시프트.jpg")
						.build();
		repository.save(book1);
		
		Book book2 = Book.builder()
						.title("파과")
						.writer("구병모")
						.publisher("위즈덤하우스")
						.price(15800)
						.category("소설")
						.imgFilename("파과.jpg")
						.build();
		repository.save(book2);
		
		Book book3 = Book.builder()
						.title("모순")
						.writer("양귀자")
						.publisher("쓰다")
						.price(13000)
						.category("소설")
						.imgFilename("모순.jpg")
						.build();
		repository.save(book3);
		
		Book book4 = Book.builder()
						.title("내 사람을 생각한다")
						.writer("김탁환")
						.publisher("남해의봄날")
						.price(11000)
						.category("소설")
						.imgFilename("내 사람을 생각한다.jpg")
						.build();
		repository.save(book4);
		
		Book book5 = Book.builder()
						.title("소년이 온다")
						.writer("한강")
						.publisher("창비")
						.price(15000)
						.category("소설")
						.imgFilename("소년이 온다.jpg")
						.build();
		repository.save(book5);
		
		Book book6 = Book.builder()
						.title("내 꿈에 가끔만 놀러와")
						.writer("고선경")
						.publisher("문학동네")
						.price(16800)
						.category("시/에세이")
						.imgFilename("내 꿈에 가끔만 놀러와.jpg")
						.build();
		repository.save(book6);
		
		Book book7 = Book.builder()
						.title("사랑과 멸종을 바꿔 읽어보십시오")
						.writer("유선혜")
						.publisher("문학과지성사")
						.price(12000)
						.category("시/에세이")
						.imgFilename("사랑과 멸종을 바꿔 읽어보십시오.jpg")
						.build();
		repository.save(book7);
		
		
		Book book8 = Book.builder()
						.title("우리의 낙원에서 만나자")
						.writer("하태완")
						.publisher("북로망스")
						.price(19500)
						.category("시/에세이")
						.imgFilename("우리의 낙원에서 만나자.jpg")
						.build();
		repository.save(book8);
		
		Book book9 = Book.builder()
						.title("빛과 실")
						.writer("한강")
						.publisher("문학과지성사")
						.price(15000)
						.category("시/에세이")
						.imgFilename("빛과 실.jpg")
						.build();
		repository.save(book9);
		
		Book book10 = Book.builder()
						.title("어른의 행복은 조용하다")
						.writer("태수")
						.publisher("페이지2북스")
						.price(17800)
						.category("시/에세이")
						.imgFilename("어른의 행복은 조용하다.jpg")
						.build();
		repository.save(book10);

		Book book11 = Book.builder()
						.title("토마토 컵라면")
						.writer("차정은")
						.publisher("부크크(Bookk)")
						.price(9000)
						.category("시/에세이")
						.imgFilename("토마토 컵라면.jpg")
						.build();
		repository.save(book11);
		
		Book book12 = Book.builder()
						.title("기울어진 평등")
						.writer("토마 피케티, 마이클 샌델")
						.publisher("와이즈베리")
						.price(17800)
						.category("인문")
						.imgFilename("기울어진 평등.jpg")
						.build();
		repository.save(book12);

		Book book13 = Book.builder()
						.title("한국이란 무엇인가")
						.writer("김영민")
						.publisher("어크로스")
						.price(18800)
						.category("인문")
						.imgFilename("한국이란 무엇인가.jpg")
						.build();
		repository.save(book13);
		
		Book book14 = Book.builder()
						.title("청춘의 독서")
						.writer("유시민")
						.publisher("웅진지식하우스")
						.price(18900)
						.category("인문")
						.imgFilename("청춘의 독서.jpg")
						.build();
		repository.save(book14);
		
		Book book15 = Book.builder()
						.title("마음의 기술")
						.writer("안-엘렌 클레르, 뱅상 트리부")
						.publisher("상상스퀘어")
						.price(21000)
						.category("인문")
						.imgFilename("마음의 기술.jpg")
						.build();
		repository.save(book15);
		
		Book book16 = Book.builder()
						.title("슬기로운 육아 처방전")
						.writer("정성관, 백정현")
						.publisher("비타북스")
						.price(20000)
						.category("가정/육아")
						.imgFilename("슬기로운 육아 처방전.jpg")
						.build();
		repository.save(book16);
		
		Book book17 = Book.builder()
						.title("엄마의 말 연습")
						.writer("윤지영")
						.publisher("카시오페아")
						.price(17500)
						.category("가정/육아")
						.imgFilename("엄마의 말 연습.jpg")
						.build();
		repository.save(book17);

		Book book18 = Book.builder()
						.title("아이의 뇌")
						.writer("김붕년")
						.publisher("포레스트북스")
						.price(17800)
						.category("가정/육아")
						.imgFilename("아이의 뇌.jpg")
						.build();
		repository.save(book18);

		Book book19 = Book.builder()
						.title("사춘기 마음을 통역해 드립니다")
						.writer("김현수")
						.publisher("미류책방")
						.price(18000)
						.category("가정/육아")
						.imgFilename("사춘기 마음을 통역해 드립니다.jpg")
						.build();
		repository.save(book19);

		Book book20 = Book.builder()
					.title("매월 알찬 집밥")
					.writer("전혜진")
					.publisher("용감한 까치")
					.price(25000)
					.category("요리")
					.imgFilename("매월 알찬 집밥.jpg")
					.build();
		repository.save(book20);
		
		Book book21 = Book.builder()
						.title("과일 케이크 레시피")
						.writer("혼마 세츠코")
						.publisher("시원북스")
						.price(16800)
						.category("요리")
						.imgFilename("과일 케이크 레시피.jpg")
						.build();
		repository.save(book21);
	
		Book book22 = Book.builder()
						.title("풍미 마스터 클래스")
						.writer("백지혜")
						.publisher("세미콜론")
						.price(25000)
						.category("요리")
						.imgFilename("풍미 마스터 클래스.jpg")
						.build();
		repository.save(book22);

		Book book23 = Book.builder()
						.title("최강록의 요리 노트")
						.writer("최강록")
						.publisher("클")
						.price(16800)
						.category("요리")
						.imgFilename("최강록의 요리 노트.jpg")
						.build();
		repository.save(book23);

		Book book24 = Book.builder()
						.title("먹던 거랑 먹는 와인")
						.writer("이영지")
						.publisher("래디시")
						.price(20000)
						.category("요리")
						.imgFilename("먹던 거랑 먹는 와인.jpg")
						.build();
		repository.save(book24);
		
		Book book25 = Book.builder()
						.title("저속노화 식사법")
						.writer("정희원")
						.publisher("테이스트북스")
						.price(19000)
						.category("건강")
						.imgFilename("저속노화 식사법.jpg")
						.build();
		repository.save(book25);

		Book book26 = Book.builder()
						.title("내 몸 혁명")
						.writer("박용우")
						.publisher("루미너스")
						.price(19500)
						.category("건강")
						.imgFilename("내 몸 혁명.jpg")
						.build();
		repository.save(book26);
		
		Book book27 = Book.builder()
						.title("수면의 뇌과학")
						.writer("크리스 윈터, 이한음")
						.publisher("현대지성")
						.price(18000)
						.category("건강")
						.imgFilename("수면의 뇌과학.jpg")
						.build();
		repository.save(book27);
		
		Book book28 = Book.builder()
						.title("환자 혁명")
						.writer("조한경")
						.publisher("에디터")
						.price(15000)
						.category("건강")
						.imgFilename("환자 혁명.jpg")
						.build();
		repository.save(book28);
		
		Book book29 = Book.builder()
						.title("힐링 코드")
						.writer("알렉산더 로이드, 벤 존슨")
						.publisher("시공사")
						.price(16800)
						.category("건강")
						.imgFilename("힐링 코드.jpg")
						.build();
		repository.save(book29);
		
		Book book30 = Book.builder()
						.title("과속 노화의 종말")
						.writer("박민수")
						.publisher("허들링북스")
						.price(18800)
						.category("건강")
						.imgFilename("과속 노화의 종말.jpg")
						.build();
		repository.save(book30);
		
		
		Book book31 = Book.builder()
						.title("내가 원하는 것을 나도 모를 때")
						.writer("전승환")
						.publisher("북로망스")
						.price(22000)
						.category("인문")
						.imgFilename("내가 원하는 것을 나도 모를 때.jpg")
						.build();
		repository.save(book31);

		Book book32 = Book.builder()
						.title("흰 고래의 흼에 대하여")
						.writer("홍한별")
						.publisher("위고")
						.price(20000)
						.category("인문")
						.imgFilename("흰 고래의 흼에 대하여.jpg")
						.build();
		repository.save(book32);
		
		Book book33 = Book.builder()
						.title("삐뽀삐뽀 119 소아과")
						.writer("하정훈")
						.publisher("유니책방")
						.price(29800)
						.category("가정/육아")
						.imgFilename("삐뽀삐뽀 119 소아과.jpg")
						.build();
		repository.save(book33);
		
		Book book34 = Book.builder()
						.title("급류")
						.writer("정대건")
						.publisher("민음사")
						.price(14000)
						.category("소설")
						.imgFilename("급류.jpg")
						.build();
		repository.save(book34);

		Book book35 = Book.builder()
						.title("스토너")
						.writer("존 윌리엄스")
						.publisher("알에이치코리아")
						.price(16800)
						.category("소설")
						.imgFilename("스토너.jpg")
						.build();
		repository.save(book35);
		
				
	}
	
	@Test
	public void 도서목록조회() {
		List<Book> list = repository.findAll();
		System.out.println(list);
	}
	
	@Test
	public void 도서단건조회() {
		Optional<Book> optional = repository.findById(1);
		
		if(optional.isPresent()) {
			Book book = optional.get();
			System.out.println(book);
		}
	}
	
	@Test
	public void 도서정보수정() {
		Optional<Book> optional = repository.findById(1);
		
		if(optional.isPresent()) {
			Book book = optional.get();
			book.setPublisher("문학동네");
			repository.save(book);
		}
	}
	
	@Test
	public void 도서삭제() {
		repository.deleteById(null);
	}
	
}
