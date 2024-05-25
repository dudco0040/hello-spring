package hello.hellospring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import hello.hellospring.domain.Member;
import hello.hellospring.service.MemberService;

@Controller
public class MemberController {
	private final MemberService memberService;
	// MemberService를 사용
	
	@Autowired
	public MemberController(MemberService memberService) {
		this.memberService = memberService;
		
	}

}
