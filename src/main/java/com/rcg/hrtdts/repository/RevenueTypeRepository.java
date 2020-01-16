package com.rcg.hrtdts.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.rcg.hrtdts.model.RevenueType;

public interface RevenueTypeRepository extends JpaRepository<RevenueType, Long>{

	@Query("SELECT rt FROM RevenueType rt where revenueTypeId=?1")
	RevenueType getRevenueData(long revenueType);

	
	

}
