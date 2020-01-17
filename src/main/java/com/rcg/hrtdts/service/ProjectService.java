/**
* @author  Jinu Shaji
* @version 1.0
* @since   2020-01-16
*/
package com.rcg.hrtdts.service;


import java.text.ParseException;

import org.json.JSONObject;

import com.rcg.hrtdts.dto.ProjectDto;
import com.rcg.hrtdts.exception.HRTDTSException;

public interface ProjectService {

	JSONObject createNewProject(ProjectDto projectDto) throws ParseException,HRTDTSException;

	JSONObject updateProject(ProjectDto projectDto) throws ParseException,HRTDTSException;
}

