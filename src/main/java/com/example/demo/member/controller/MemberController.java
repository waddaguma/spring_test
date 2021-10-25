package com.example.demo.member.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.member.service.MemberService;

import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

@Slf4j

//@RequestMapping(value="/members")
@RequestMapping("/test01")
@RestController
public class MemberController {

	@Autowired
	private MemberService memberService;
	
	@ApiOperation("TEST")
	@GetMapping("/fetch01")
	public void memberStart() {
    System.out.println("fetch01 : postgres(member -> target_member)");
		memberService.processMember();
	}
	
	
	@ApiOperation("TEST")
	@GetMapping("/fetch02")
	public void memberStartOracle() {
    System.out.println("fetch01 : (oracle:member -> postgres:target_member)");
		memberService.processMemberOracle();
	}


}
