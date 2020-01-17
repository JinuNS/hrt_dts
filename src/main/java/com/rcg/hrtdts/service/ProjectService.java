/**
* @author  Jinu Shaji
* @version 1.0
* @since   2020-01-16
*/
package com.rcg.hrtdts.service;

import java.text.ParseException;

import org.json.simple.JSONObject;

import com.rcg.hrtdts.dto.ProjectDto;
import com.rcg.hrtdts.dto.ProjectHrtDto;
import com.rcg.hrtdts.model.StatusResponse;

public interface ProjectService {

	JSONObject createNewProject(ProjectDto projectDto) throws ParseException;

	StatusResponse projectListDataForAdmin(ProjectHrtDto projectHrtDto) throws Exception;
}
