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
public interface ProjectDao {
	void createProject(Project project) throws DataAccessException;
	Project getProjectById(int projectId) throws ProjectNotFoundException,DataAccessException;
	Set<Project> getAllProjects() throws DataAccessException;
	Set<Project> getProjectsManagedByUser(int projectManagerId) throws DataAccessException;
	Team getProjectTeam(int projectId) throws TeamNotFoundException,DataAccessException;
	Set<Bug> getProjectBugs(int projectId) throws DataAccessException;
	
}
