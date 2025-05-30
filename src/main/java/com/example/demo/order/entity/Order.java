package com.example.demo.order.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.example.demo.book.entity.Book;
import com.example.demo.member.entity.Member;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
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

@EntityListeners(AuditingEntityListener.class)
@Entity
@Table(name = "tbl_order")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class Order {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "order_no")
	int orderNo; // 주문번호
	
	@OneToMany(mappedBy = "order",cascade = CascadeType.ALL)
	List<OrderItem> orderItems = new ArrayList<>(); // 주문 상세 리스트
	
//	@ManyToOne(fetch = FetchType.LAZY)
	@ManyToOne
	@JoinColumn(name = "member_no", nullable = false)
	Member member; // 주문자
	
	@CreatedDate
	@Column(updatable = false)
	LocalDateTime orderDate; // 주문일시
	
	@Column(nullable = false)
	int totalPrice; // 총 주문 금액


}
