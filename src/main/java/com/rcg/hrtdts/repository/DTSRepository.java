package com.rcg.hrtdts.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.rcg.hrtdts.model.DTSModel;

public interface DTSRepository extends JpaRepository<DTSModel, Long>{

	@Query("SELECT dts FROM DTSModel dts where dts.dtsNo=?1 AND dts.status!='CLOSED'")
	DTSModel getDtsInformation(Long dtsNo);

	@Query("SELECT dts FROM DTSModel dts where dts.id=?1")
	DTSModel getDtsData(Long dtsId);

	@Query(value="SELECT id,dtsNo,empId_eId,projectName_projectId,status,startDate,endDate FROM DTSModel where empId_eId=?1 ORDER BY id DESC limit 1 ",nativeQuery=true)
	List<Object[]> getAllDtsInformation(Long geteId);

	@Query(value="SELECT dtsNo FROM dtsmodel ORDER BY dtsNo DESC LIMIT 1;",nativeQuery=true)
	Long getDtsNumber();

	@Query("SELECT count(*) FROM DTSModel where empId.eId=?1 AND status!='CLOSED'")
	int checkingUserDtsStatus(Long empId);

}
