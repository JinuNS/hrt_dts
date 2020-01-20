package com.rcg.hrtdts.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.rcg.hrtdts.model.DTSModel;

public interface DTSRepository extends JpaRepository<DTSModel, Long>{

	@Query("SELECT id,dtsNo,empId.eId,projectName.projectId,status,startDate,endDate FROM DTSModel")
	List<Object[]> getAllDtsInformation();

	@Query("SELECT dts FROM DTSModel dts where dts.dtsNo=?1")
	DTSModel getDtsInformation(Long dtsNo);

	@Query("SELECT dts FROM DTSModel dts where dts.id=?1")
	DTSModel getDtsData(Long dtsId);

}
