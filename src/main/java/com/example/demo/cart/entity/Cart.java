package com.example.demo.cart.entity;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.book.entity.Book;
import com.example.demo.member.entity.Member;
import com.example.demo.order.entity.OrderItem;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "tbl_cart")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class Cart {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int cartNo; // 장바구니 번호
	
	@ManyToOne
//	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "book_no", nullable = false)
	Book book; // 도서
		
//	@ManyToOne(fetch = FetchType.LAZY)
	@ManyToOne
	@JoinColumn(name = "member_no", nullable = false)
	Member member; // 회원
	
	@Column(nullable = false)
	int quantity; // 수량
	
//	@OneToMany(mappedBy = "cart", cascade = CascadeType.REMOVE, orphanRemoval = true)
//    private List<OrderItem> orderItems = new ArrayList<>();
	
}
