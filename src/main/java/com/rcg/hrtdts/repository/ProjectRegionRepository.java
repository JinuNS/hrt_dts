package com.rcg.hrtdts.repository;



import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.rcg.hrtdts.model.ProjectRegion;


public interface ProjectRegionRepository extends JpaRepository<ProjectRegion, Long> {

	@Query("SELECT r FROM ProjectRegion r WHERE r.project_Id.projectId=?1")
	List<ProjectRegion> getRegionList(long projectId);

	@Modifying
	@Transactional
	@Query("delete from ProjectRegion p where p.project_Id.projectId = ?1")
	int deleteByProjectId(Long projectId);
	
}
