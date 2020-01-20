package com.rcg.hrtdts.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.rcg.hrtdts.model.ProjectModel;

public interface ProjectRepository extends JpaRepository<ProjectModel, Long>{

	@Query("SELECT projectId,projectName FROM ProjectModel")
	ArrayList<Object[]> getAllProjectName();
	
	@Query("SELECT count(p) FROM ProjectModel p WHERE p.projectCode=?1")
	int findprojectbycode(String projectCode);
	
	@Query("SELECT  p   from ProjectModel  p where p.parentProjectId != 0 AND p.projectStatus=1 order by p.projectName Asc")
	List<ProjectModel> getProjectsOnly();

	@Query("SELECT count(p) FROM ProjectModel p WHERE p.projectName=?1")
	int findProject(String getprojectName);
	
	@Query(value = "SELECT project FROM ProjectModel project where project.parentProjectId !=0 order by project.projectName ASC")
	ArrayList<ProjectModel> getAllNonParentProjects();
	
	@Query("SELECT s.projectName FROM ProjectModel s where s.projectId=?1")
	String getProjectName(Long projectId);
}
