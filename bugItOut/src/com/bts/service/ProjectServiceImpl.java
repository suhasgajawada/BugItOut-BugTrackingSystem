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
	ProjectDao projectDaoService = null;
	public ProjectServiceImpl() {
		 projectDaoService = ObjectFactory.getProjectDaoInstance();
	}

	@Override
	public void createProject(Project project)
			throws DataAccessException, InvalidDataException, ProjectManagerLimitExceededException {
		try {
			projectDaoService.createProject(project);
		} catch (DataAccessException  /*InvalidDataException ProjectManagerLimitExceededException */e) {
			e.getMessage();
		}
	}

	@Override
	public Project getProjectById(int projectId) throws ProjectNotFoundException, DataAccessException {
		Project projectById = null;
		try {
			projectById = projectDaoService.getProjectById(projectId);
		} catch (ProjectNotFoundException | DataAccessException e) {
			e.getMessage();
		}
		return projectById;
	}

	@Override
	public Set<Project> getAllProjects() throws DataAccessException {
			Set<Project> projects = null;
			try {
				projects = projectDaoService.getAllProjects();
			} catch (DataAccessException e) {
				e.getMessage();
			}
		return projects;
	}

	@Override
	public Set<Project> getProjectsManagedByUser(int projectManagerId) throws DataAccessException {
		Set<Project> projectsByUser = null;
		try {
			projectsByUser = projectDaoService.getProjectsManagedByUser(projectManagerId);
		} catch (DataAccessException e) {
			e.getMessage();
		}
	return projectsByUser;
	}

	@Override
	public Team getProjectTeam(int projectId) throws TeamNotFoundException, DataAccessException {
		Team projectTeam = null;
		try {
			projectTeam = projectDaoService.getProjectTeam(projectId);
			
		}catch (TeamNotFoundException | DataAccessException e) {
			e.getMessage();
		}
		return projectTeam;
	}

	@Override
	public Set<Bug> getProjectBugs(int projectId) throws DataAccessException {
		Set<Bug> projectBugs = null;
		try {
			projectBugs = projectDaoService.getProjectBugs(projectId);
		}catch(DataAccessException e){
			e.getMessage();
		}
		return projectBugs;
	}

}
