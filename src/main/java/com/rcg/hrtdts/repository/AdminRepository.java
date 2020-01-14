package com.rcg.hrtdts.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rcg.hrtdts.model.AdminDetails;


public interface AdminRepository extends JpaRepository<AdminDetails,Long>{

}
