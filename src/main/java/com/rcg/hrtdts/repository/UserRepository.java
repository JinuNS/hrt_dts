package com.rcg.hrtdts.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rcg.hrtdts.model.UserModel;
/**
 * 
 * @author  charly
 * @version 1.0
 * @since   2020-01-16 
 * 
 **/
@Repository
public interface UserRepository extends JpaRepository<UserModel, Long> {

	UserModel findByuserName(String username);

}
