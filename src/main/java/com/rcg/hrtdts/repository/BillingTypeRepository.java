package com.rcg.hrtdts.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.rcg.hrtdts.model.BillingType;

public interface BillingTypeRepository extends JpaRepository<BillingType, Long>{

	@Query("SELECT bt FROM BillingType bt where billingTypeId=?1")
	BillingType findBillingType(long billingTypeId);

}
