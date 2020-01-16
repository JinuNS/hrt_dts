package com.rcg.hrtdts.serviceImpl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rcg.hrtdts.model.RegionModel;
import com.rcg.hrtdts.repository.RegionRepository;
import com.rcg.hrtdts.service.RegionService;

@Service
public class RegionServiceImplementation implements RegionService {

	
	@Autowired
	private RegionRepository regionRepository;
	

	@Override
	public RegionModel getregion(Long region_Id) {
		// TODO Auto-generated method stub
		
		return regionRepository.getOne(region_Id);
	}



	

}
