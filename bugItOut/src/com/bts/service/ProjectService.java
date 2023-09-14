/**
 * 
 */
package com.bts.service;

import java.util.Set;

import com.bts.beans.Bug;
import com.bts.beans.Project;
import com.bts.beans.Team;
import com.bts.exceptions.AuthenticationException;
import com.bts.exceptions.DataAccessException;
import com.bts.exceptions.InvalidDataException;
import com.bts.exceptions.ProjectManagerLimitExceededException;
import com.bts.exceptions.ProjectNotFoundException;
import com.bts.exceptions.TeamNotFoundException;

/**
 * 
 */
public interface ProjectService {
    Project getProjectByID(int projectID) throws ProjectNotFoundException, DataAccessException;
    Set<Project> getAllProjects() throws DataAccessException;
    Set<Project> getProjectsManagedByUser(int projectManagerID) throws DataAccessException, AuthenticationException;
    Set<Team> getProjectTeam(int projectID) throws TeamNotFoundException, DataAccessException;
	void createProject(Project project, int projectManagerId, int testerId)
			throws DataAccessException, ProjectManagerLimitExceededException;

}
