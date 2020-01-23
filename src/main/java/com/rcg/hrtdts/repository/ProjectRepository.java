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

	@Query("SELECT p.projectId,p.projectName FROM ProjectModel p WHERE p.clientName.clientId=?1")
	ArrayList<Object[]> getAllProjectsByClient(Long clientId);

	@Query("SELECT p FROM ProjectModel p WHERE p.projectId=?1")
	ProjectModel getProjectdata(Long projectName);
	
	@Query("SELECT p from ProjectModel  p where p.projectStatus=1 order by p.projectName Asc")
	List<ProjectModel> getAllActiveProjectList();

	@Query("SELECT p from ProjectModel p where p.projectOwner.eId =?1 AND p.projectStatus=1 order by p.projectName Asc")
	List<ProjectModel> getProjectListByLevel1(Long userId);

	@Query("SELECT p from ProjectModel p where p.onsiteLead.eId =?1 AND p.projectStatus=1 order by p.projectName Asc")
	List<ProjectModel> getProjectListByLevel2(Long userId);
}
