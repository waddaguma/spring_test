package com.example.demo.nmsmember.repository;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.example.demo.member.domain.Member;

@Mapper
@Repository
public interface NmsRepository {

	List<Member> fetchAll();

}
