package com.rcg.hrtdts.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.rcg.hrtdts.model.Resources;

public interface ResourceRepository extends JpaRepository<Resources, Long> {

	@Query("SELECT r FROM Resources r WHERE r.project.projectId=?1")
	List<Resources> getResourceList(long projectId);

}
