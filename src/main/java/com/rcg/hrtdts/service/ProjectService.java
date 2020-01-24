/**
* @author  Jinu Shaji
* @version 1.0
* @since   2020-01-16
*/
package com.rcg.hrtdts.service;

import java.text.ParseException;
import java.util.ArrayList;
import org.json.simple.JSONObject;
import com.rcg.hrtdts.dto.ProjectDto;
import com.rcg.hrtdts.dto.SingleProjectResposneDto;
import com.rcg.hrtdts.exception.HRTDTSException;

public interface ProjectService {

	JSONObject createNewProject(ProjectDto projectDto) throws ParseException, HRTDTSException, Exception;

	JSONObject updateProject(ProjectDto projectDto) throws ParseException, HRTDTSException, Exception;

	JSONObject projectListDataForAdmin(ProjectDto projectDto) throws Exception;

	ArrayList viewAllProjects(ProjectDto projectHrtDto);

	SingleProjectResposneDto getSingleProject(Long projectId) throws Exception, HRTDTSException;
}
