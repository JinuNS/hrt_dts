package com.rcg.hrtdts.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rcg.hrtdts.model.PageRule;
import com.rcg.hrtdts.model.RoleModel;

/**
 * 
 * @author  charly
 * @version 1.0
 * @since   2020-01-16 
 * 
 **/
@Repository
public interface PageRuleRepository extends JpaRepository<PageRule, Long> {

	List<PageRule> findByroleId(Long roleId);

}
