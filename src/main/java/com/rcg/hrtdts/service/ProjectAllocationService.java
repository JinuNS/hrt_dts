package com.rcg.hrtdts.service;

import java.text.ParseException;
import org.json.simple.JSONObject;
import com.rcg.hrtdts.dto.PojectAllocationListDto;
import com.rcg.hrtdts.dto.ProjectAllocationUserListDto;
import com.rcg.hrtdts.dto.ProjectDto;
import com.rcg.hrtdts.dto.SaveAllocationDto;

public interface ProjectAllocationService {

	public JSONObject getProjectlistByRegion(PojectAllocationListDto projectDto);

	public JSONObject getUserlistByRegion(ProjectAllocationUserListDto projectDto) throws ParseException;

	public JSONObject getUsersByRegion(ProjectDto projectDto);

	public JSONObject getResourceListByProjects(ProjectDto projectDto) throws ParseException;

	public JSONObject saveAllocation(SaveAllocationDto saveAllocationDto);

	public JSONObject editAllocation(SaveAllocationDto saveAllocationDto);

}
