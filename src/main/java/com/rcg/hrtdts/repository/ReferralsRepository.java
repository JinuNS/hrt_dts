package com.rcg.hrtdts.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.rcg.hrtdts.model.ReferralsModel;
/**
 * 
 * @author  neena
 * @version 1.0
 * @since   2020-01-14 
 * 
 **/
public interface ReferralsRepository extends JpaRepository<ReferralsModel, Long>{

	@Query("select r from ReferralsModel r where r.id = ?1")
	ReferralsModel findByReferralId(Long referralId);

}
