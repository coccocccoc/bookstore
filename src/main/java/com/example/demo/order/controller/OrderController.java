package com.example.demo.order.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.cart.dto.CartDTO;
import com.example.demo.cart.entity.Cart;
import com.example.demo.cart.repository.CartRepository;
import com.example.demo.member.entity.Member;
import com.example.demo.member.repository.MemberRepository;
import com.example.demo.order.dto.OrderDTO;
import com.example.demo.order.dto.OrderItemDTO;
import com.example.demo.order.entity.Order;
import com.example.demo.order.service.OrderService;

@Controller
@RequestMapping("/bookstore")
public class OrderController {
	
	@Autowired
	OrderService orderService;
	
	@Autowired
	MemberRepository memberRepository;
	
	@Autowired
	CartRepository cartRepository;
	
	@ModelAttribute("categoryList")
	 public List<String> getCategoryList() {
	   return List.of("소설", "시/에세이", "인문", "가정/육아", "요리", "건강");
	 }
	
	// 주문 화면 반환 (목록 조회, 총 합계 계산, 총 수량 계산)
	@GetMapping("/book-order")
	public String orderPage(Model model) {
	    int memberNo = 1;
	    
	    List<Cart> cartList = cartRepository.findByMemberMemberNo(memberNo);
	    model.addAttribute("cartList", cartList);
	    
	    Member member = memberRepository.findById(memberNo).orElseThrow();
	    model.addAttribute("member", member);

	    // 총 합계 계산
	    int totalPrice = 0;
	    for (Cart cart : cartList) {
	        int price = (int)(cart.getBook().getPrice() * 0.9);
	        totalPrice = totalPrice + price * cart.getQuantity();
	    }
	    model.addAttribute("totalPrice", totalPrice);

	    // 총 수량 계산
	    int totalQuantity = 0;
	    for (Cart cart : cartList) {
	        totalQuantity = totalQuantity + cart.getQuantity();
	    }
	    model.addAttribute("totalQuantity", totalQuantity);
	    

	    return "/book-order";
	}

	
    @PostMapping("/book-order/submit")
    public String submitOrder() {

    	int memberNo = 1;

        orderService.saveOrderFromCart(memberNo);

        return "redirect:/book-cart?orderSuccess=true";
    }
	
	// 마이페이지 반환
    @GetMapping("/my")
    public String myPage(Model model) {
        int memberNo = 1;
        Member member = memberRepository.findById(memberNo).orElseThrow();
 
        List<Order> orderList = orderService.findOrdersByMemberNo(memberNo);

        model.addAttribute("member", member);
        model.addAttribute("orderList", orderList);

        return "/my";
    }
    
    @GetMapping("/order-detail")
    public String orderDetail(@RequestParam("orderNo") int orderNo, Model model) {
        Order order = orderService.findOrderByOrderNo(orderNo)
                                  .orElseThrow(() -> new RuntimeException("주문을 찾을 수 없습니다."));
        model.addAttribute("order", order);
        return "/order-detail";
    }



}
