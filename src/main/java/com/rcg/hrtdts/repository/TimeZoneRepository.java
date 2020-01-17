package com.rcg.hrtdts.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rcg.hrtdts.model.TimeZoneModel;

public interface TimeZoneRepository extends JpaRepository<TimeZoneModel, Long>{

}
