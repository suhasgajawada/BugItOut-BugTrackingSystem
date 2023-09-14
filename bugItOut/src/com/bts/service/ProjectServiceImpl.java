/**
 * 
 */
package com.bts.service;

import java.util.HashSet;
import java.util.Set;

import com.bts.beans.Bug;
import com.bts.beans.Project;
import com.bts.beans.Team;
import com.bts.beans.User;
import com.bts.beans.enums.UserType;
import com.bts.dao.ProjectDao;
import com.bts.dao.TeamDao;
import com.bts.dao.UserDao;
import com.bts.exceptions.AuthenticationException;
import com.bts.exceptions.DataAccessException;
import com.bts.exceptions.InvalidDataException;
import com.bts.exceptions.ProjectManagerLimitExceededException;
import com.bts.exceptions.ProjectNotFoundException;
import com.bts.exceptions.TeamNotFoundException;
import com.bts.exceptions.UserNotFoundException;
import com.bts.util.ObjectFactory;

/**
 * 
 */
public class ProjectServiceImpl implements ProjectService {

	/**
	 * 
	 */
	ProjectDao projectDaoService = null;
	UserDao userDaoService = null;
	TeamDao teamDaoService = null;
	public ProjectServiceImpl() {
		 projectDaoService = ObjectFactory.getProjectDaoInstance();
		 userDaoService = ObjectFactory.getUserDaoInstance();
		 teamDaoService = ObjectFactory.getTeamDaoInstance();
		 }

	@Override
	public void createProject(Project project,int projectManagerId, int testerId)
			throws DataAccessException,ProjectManagerLimitExceededException {
		try {
			projectDaoService.createProject(project);
		} catch (DataAccessException e) {
			throw new DataAccessException(e.getMessage(),e);
		}

	}

	@Override
	public Project getProjectByID(int projectID) throws ProjectNotFoundException, DataAccessException {
		Project project = null;	
		try {
				project = projectDaoService.getProjectById(projectID);
				
			} catch (ProjectNotFoundException e) {
				throw new ProjectNotFoundException(e.getMessage(),e);
			}catch(DataAccessException e) {
				throw new DataAccessException(e.getMessage(),e);
			}
		return project;
	}

	@Override
	public Set<Project> getAllProjects() throws DataAccessException {
		Set<Project> projects = new HashSet<>();
		try {
			 projects = projectDaoService.getAllProjects();
		
		}catch(DataAccessException e) {
				throw new DataAccessException(e.getMessage(),e);
		}
		return projects;
	}

	@Override
	public Set<Project> getProjectsManagedByUser(int projectManagerID) throws DataAccessException, AuthenticationException {
		Set <Project> projects = new HashSet<Project>();
		try {
			User user = userDaoService.getUserById(projectManagerID);
			if(user.getUserType().equals(UserType.projectManager)) {
				projects=getProjectsManagedByUser(projectManagerID);
			}
			else {
				throw new AuthenticationException("Projects can be viewed managers only : Unauthorized Access");
			}
		} catch (UserNotFoundException e) {
			throw new DataAccessException(e.getMessage(),e);
		} catch (DataAccessException e) {
			throw new DataAccessException(e.getMessage(),e);
		}
		
		return projects;
	}

	@Override
	public Set<Team> getProjectTeam(int projectID) throws TeamNotFoundException, DataAccessException {
		Set<Team> team = new HashSet<Team>();
		try {
			 team = projectDaoService.getProjectTeam(projectID);
		} catch (TeamNotFoundException e) {
				throw new TeamNotFoundException(e.getMessage(),e);
		}catch(DataAccessException e) {
				throw new DataAccessException(e.getMessage(),e);
		}
		return team;
	}

}
