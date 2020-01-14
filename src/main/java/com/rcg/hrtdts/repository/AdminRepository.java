/**
* @author  Jinu Shaji
* @version 1.0
* @since   2020-01-10 
*/

package com.rcg.hrtdts.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rcg.hrtdts.model.AdminDetails;


public interface AdminRepository extends JpaRepository<AdminDetails,Long>{

}
