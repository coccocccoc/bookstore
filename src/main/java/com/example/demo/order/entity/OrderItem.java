package com.example.demo.order.entity;

import com.example.demo.book.entity.Book;
import com.example.demo.cart.entity.Cart;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "tbl_order_item")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class OrderItem {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int orderItemNo; // 주문 상세 번호
	
	@ManyToOne
	@JoinColumn(name = "order_no", nullable = false)
	Order order; // 주문
	
	@ManyToOne
	@JoinColumn(name = "book_no", nullable = false)
	Book book; // 도서
	
	int quantity; // 수량

}
