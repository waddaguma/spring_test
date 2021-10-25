package com.example.demo.system.networkassetlist.infra.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

import com.example.demo.system.networkassetlist.infra.domain.IfrNetworkList;


@Repository
public interface IfrNetworkListRepository extends JpaRepository<IfrNetworkList,Long>, QuerydslPredicateExecutor<IfrNetworkList>{

}

