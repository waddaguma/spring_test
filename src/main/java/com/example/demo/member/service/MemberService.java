package com.example.demo.member.service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.member.domain.Member;
import com.example.demo.member.repository.MemberRepository;
import com.example.demo.nmsmember.repository.NmsRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@Transactional
public class MemberService {


	@Autowired
	private MemberSave memberSave;

	@Autowired
	private MemberRepository memberRepository;

	@Autowired
	NmsRepository nmsRepository ;

	public void processMember() {

//		List<Member> li = memberRepository.fetchByActive("f");
		List<Member> li = memberRepository.findAll();

		for(Member i : li) {

			try {
				memberSave.oneSave(i);
			}catch(Exception e) {
				//		log.debug(e.toString);
			}
		}

	}
	
	public void processMemberOracle() {
		
		 DriverManagerDataSource dataSource = new DriverManagerDataSource();
		 
		 dataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		 dataSource.setUrl("jdbc:oracle:thin:@localhost:1521/ORCL");
		 dataSource.setUsername("system");
		 dataSource.setPassword("Mook@2736");
		 
		 String query = "select * from member";

	        try(Connection connection = dataSource.getConnection()){
	            System.out.println(connection);
	            String URL = connection.getMetaData().getURL();
	            System.out.println(URL);
	            String User = connection.getMetaData().getUserName();
	            System.out.println(User);
	            
	            Statement statement = connection.createStatement();
	            ResultSet rs = statement.executeQuery(query);
	            
	            while(rs.next()){ 
	        		Member member = new Member();
	                System.out.println("name : " + rs.getString("name"));
	                System.out.println("id : " + rs.getString("id"));
	                System.out.println("zipcode : " + rs.getString("zipcode"));
	                
	                
	                member.setId(rs.getLong("id"));
	                member.setEmail(rs.getString("email"));
	                member.setActive(rs.getString("active"));
	                member.setName(rs.getString("name"));
	                member.setZipcode(rs.getString("zipcode"));
	                
	            	
	            	memberSave.oneSave(member);
	            	
	                }
	            
	        } catch(Exception e) {
	        	System.out.println(e.toString());
	        }
	        }
		
	}

