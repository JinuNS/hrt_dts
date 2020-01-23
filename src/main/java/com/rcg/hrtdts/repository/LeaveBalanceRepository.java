package com.rcg.hrtdts.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.rcg.hrtdts.model.LeaveBalanceModel;

public interface LeaveBalanceRepository extends JpaRepository<LeaveBalanceModel, Long> {
	@Query("SELECT l FROM LeaveBalanceModel l where l.user.userId = ?1 and l.quarter = ?2 and l.year = ?3")
	LeaveBalanceModel getLeaveBalance(Long userId, int quater, int year);
}
