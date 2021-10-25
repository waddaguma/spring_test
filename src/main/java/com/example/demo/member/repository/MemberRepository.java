package com.example.demo.member.repository;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

import com.example.demo.member.domain.Member;

@Repository
public interface MemberRepository extends JpaRepository<Member,Long>, QuerydslPredicateExecutor<Member>{
	List<Member> findAll();
		
}
