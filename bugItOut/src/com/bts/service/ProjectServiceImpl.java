/**
 * 
 */
package com.bts.service;

import java.util.Set;

import com.bts.beans.Bug;
import com.bts.beans.Project;
import com.bts.beans.Team;
import com.bts.dao.ProjectDao;
import com.bts.exceptions.DataAccessException;
import com.bts.exceptions.InvalidDataException;
import com.bts.exceptions.ProjectManagerLimitExceededException;
import com.bts.exceptions.ProjectNotFoundException;
import com.bts.exceptions.TeamNotFoundException;
import com.bts.util.ObjectFactory;

/**
 * 
 */
public class ProjectServiceImpl implements ProjectService {

	/**
	 * 
	 */
	public ProjectServiceImpl() {
		ProjectDao projectDaoService = ObjectFactory.getProjectDaoInstance();
	}

	@Override
	public void createProject(Project project)
			throws DataAccessException, InvalidDataException, ProjectManagerLimitExceededException {
		// TODO Auto-generated method stub

	}

	@Override
	public Project getProjectByID(int projectID) throws ProjectNotFoundException, DataAccessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<Project> getAllProjects() throws DataAccessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<Project> getProjectsManagedByUser(int projectManagerID) throws DataAccessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Team getProjectTeam(int projectID) throws TeamNotFoundException, DataAccessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<Bug> getProjectBugs(int projectID) throws DataAccessException {
		// TODO Auto-generated method stub
		return null;
	}

}
