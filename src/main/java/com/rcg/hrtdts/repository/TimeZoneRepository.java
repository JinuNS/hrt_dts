package com.rcg.hrtdts.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.rcg.hrtdts.model.TimeZoneModel;

public interface TimeZoneRepository extends JpaRepository<TimeZoneModel, Long>{
	@Query("SELECT s FROM TimeZoneModel s")
	ArrayList<TimeZoneModel> getTimeZones1();
}
