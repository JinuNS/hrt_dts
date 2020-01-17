package com.rcg.hrtdts.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.rcg.hrtdts.model.ProjectModel;

public interface ProjectRepository extends JpaRepository<ProjectModel, Long>{

	@Query("SELECT projectId,projectName FROM ProjectModel")
	ArrayList<Object[]> getAllProjectName();
	
	@Query("SELECT count(p) FROM ProjectModel p WHERE p.projectCode=?1")
	int findprojectbycode(String projectCode);

}
