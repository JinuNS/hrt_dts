package com.rcg.hrtdts.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.rcg.hrtdts.model.ProjectManager;

public interface ProjectManagerRepository extends JpaRepository<ProjectManager, Long>{

	@Query("SELECT pm FROM ProjectManager pm where projectManagerId=?1")
	ProjectManager getprojectManager(long projectManager);

}
