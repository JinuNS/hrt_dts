package com.rcg.hrtdts.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.rcg.hrtdts.model.AllocationModel;

public interface AllocationRepository extends JpaRepository<AllocationModel,Long> {
	@Query("SELECT count(*) > 0 FROM AllocationModel s WHERE s.user.userId = ?1")
	Boolean isExists(long userId);
	
	@Query("SELECT s FROM AllocationModel s WHERE s.project.projectId = ?1")
	List<AllocationModel> getProjectLists(Long projectId);
	
	@Query("SELECT s FROM AllocationModel s join UserModel u on u.userId=s.user.userId WHERE s.user.userId =:userId and s.startDate <:date2 and s.endDate >:date1 order by u.employee.firstName")
	List<AllocationModel> findUsers(long userId, Date date1,Date date2);
}
