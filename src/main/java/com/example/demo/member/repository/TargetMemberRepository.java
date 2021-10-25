package com.example.demo.member.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import com.example.demo.member.domain.TargetMember;

public interface TargetMemberRepository extends JpaRepository<TargetMember,Long>, QuerydslPredicateExecutor<TargetMember>{

}
