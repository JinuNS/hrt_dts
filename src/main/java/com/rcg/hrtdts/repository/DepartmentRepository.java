package com.rcg.hrtdts.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.rcg.hrtdts.model.DepartmentModel;

public interface DepartmentRepository extends JpaRepository<DepartmentModel, Long>{



}
