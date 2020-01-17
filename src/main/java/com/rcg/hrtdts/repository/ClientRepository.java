package com.rcg.hrtdts.repository;

import java.util.ArrayList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.rcg.hrtdts.model.ClientModel;

public interface ClientRepository extends JpaRepository<ClientModel, Long> {

	@Query("SELECT clientId,clientName FROM ClientModel")
	ArrayList<Object[]> getAllClientName();

	@Query("Select s From ClientModel s order by clientName")
	ArrayList<ClientModel> getAll();

}
