package com.example.demo.member.service;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.member.domain.Member;
import com.example.demo.member.domain.TargetMember;
import com.example.demo.member.repository.MemberRepository;
import com.example.demo.member.repository.TargetMemberRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@Transactional(propagation=Propagation.REQUIRES_NEW,noRollbackFor = Exception.class)
public class MemberSave {

	@Autowired
	private TargetMemberRepository targetMemberRepository;

//	public void oneSave(Member i) {
	
	public void oneSave(Member i) {
			
		TargetMember targetMember = new TargetMember();
		try {
			
			System.out.println(i.getId());
			targetMember.setId(i.getId());
			targetMember.setName(i.getName());
			targetMember.setActive(i.getActive());
			targetMember.setZipcode(i.getZipcode());
			targetMember.setEmail(i.getEmail());

			System.out.println(targetMember.getId());
		
			targetMemberRepository.save(targetMember);
			
			
		}catch (Exception e) {
			System.out.println("Error");
						System.out.println(e.toString());
			
		}
	}



}
