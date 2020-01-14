package com.rcg.hrtdts.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rcg.hrtdts.model.UserDetails;


public interface UserRepository extends JpaRepository<UserDetails,Long>{

}
