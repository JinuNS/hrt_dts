package com.rcg.hrtdts.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.rcg.hrtdts.model.ContractModel;

public interface ContractRepository extends JpaRepository<ContractModel, Long> {
	@Query("select s from ContractModel s where contractTypeId=?1")
	ContractModel getContract(Long contractId);

}
