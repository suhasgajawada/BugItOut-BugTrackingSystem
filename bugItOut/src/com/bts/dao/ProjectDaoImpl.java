/**
 * 
 */
package com.bts.dao;

import java.util.Set;

import com.bts.beans.Bug;
import com.bts.beans.Project;
import com.bts.beans.Team;
import com.bts.exceptions.DataAccessException;
import com.bts.exceptions.ProjectNotFoundException;
import com.bts.exceptions.TeamNotFoundException;

/**
 * 
 */
public class ProjectDaoImpl implements ProjectDao {

	@Override
	public void createProject(Project project) throws DataAccessException {
		// TODO Auto-generated method stub

	}

	@Override
	public Project getProjectById(int projectId) throws ProjectNotFoundException, DataAccessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<Project> getAllProjects() throws DataAccessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<Project> getProjectsManagedByUser(int projectManagerId) throws DataAccessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Team getProjectTeam(int projectId) throws TeamNotFoundException, DataAccessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<Bug> getProjectBugs(int projectId) throws DataAccessException {
		// TODO Auto-generated method stub
		return null;
	}

}
