package com.rcg.hrtdts.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.rcg.hrtdts.model.RegionModel;

public interface RegionRepository extends JpaRepository<RegionModel, Long>{

	@Query("SELECT rm FROM RegionModel rm where id=?1")
	RegionModel findRegionName(long regionId);

}
