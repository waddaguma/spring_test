package com.example.demo.system.networkassetlist.controller;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.ifrmember.service.IfrMemberService;

//import io.swagger.annotations.ApiOperation;

@RequestMapping("/networklist")
@RestController
public class IfrNetworkListController {

//	@Autowired
//	DataSource dataSource;

//	@Autowired
//	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private IfrMemberService ifrMemberService;
	
//	@ApiOperation("TEST")
	@GetMapping("/ifrnetworklist")
	public void ifrMemberStart() {
//	public String ifrMemberStart() {
//		log.debug("member fetch");
//		return "START";
		ifrMemberService.processIfrMember();
	}

}
