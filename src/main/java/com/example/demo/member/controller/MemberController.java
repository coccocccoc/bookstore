package com.example.demo.member.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.member.dto.MemberDTO;
import com.example.demo.member.service.MemberService;

@Controller
@RequestMapping("/bookstore")
public class MemberController {
	
	@Autowired
	MemberService memberService;

	public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/sign-up") 
    public String signUpForm() {
        return "sign-up";
    }

    @PostMapping("/sign-up")
    public String signUp(@ModelAttribute MemberDTO dto) {
        memberService.register(dto);
        return "redirect:/login";
    }

    @GetMapping("/login")
    public String loginForm() {
        return "login";
    }
	
}
