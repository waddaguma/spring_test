package com.example.demo.system.networkassetlist.nms.repository;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

import com.example.demo.system.networkassetlist.nms.domain.NmsNetworkList;

@Repository
public interface NmsNetworkListRepository extends JpaRepository<NmsNetworkList,Long>, QuerydslPredicateExecutor<NmsNetworkList>{
//	List<NmsNetworkList> findAll();

	@Query(value = "select * from network_list where bactch_flag = :batchFlag", nativeQuery=true)
	List<NmsNetworkList> fetchByBatchFlag(@Param("batchFlag") String batchFlad);
}
