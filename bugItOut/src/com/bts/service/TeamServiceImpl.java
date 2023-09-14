/**
 * 
 */
package com.bts.service;

import java.sql.SQLException;
import java.util.Set;

import com.bts.beans.Team;
import com.bts.beans.User;
import com.bts.dao.TeamDao;
import com.bts.exceptions.DataAccessException;
import com.bts.exceptions.InvalidDataException;
import com.bts.exceptions.TeamNotFoundException;
import com.bts.util.ObjectFactory;

/**
 * 
 */
public class TeamServiceImpl implements TeamService {

	/**
	 * 
	 */
	TeamDao teamDaoService = null;
	public TeamServiceImpl() {
		teamDaoService = ObjectFactory.getTeamDaoInstance();
	}

	@Override
	public void createTeam(Team team) throws DataAccessException, InvalidDataException, TeamNotFoundException {
		try {
			teamDaoService.createTeam(team);
		} catch (DataAccessException e) {
			throw new DataAccessException(e.getMessage());
		} catch (ClassNotFoundException e) {
			throw new DataAccessException(e.getMessage());
		} catch (SQLException e) {
			throw new DataAccessException(e.getMessage());
		}

	}

	@Override
	public Team getTeamByID(int teamID) throws TeamNotFoundException, DataAccessException {
		try {
			return teamDaoService.getTeamByID(teamID);
		} catch (DataAccessException e) {
			throw new DataAccessException(e.getMessage());
		} catch (TeamNotFoundException e) {
			throw new TeamNotFoundException(e.getMessage());
		}
	}

	@Override
	public Team getTeamByProjectID(int projectID) throws TeamNotFoundException, DataAccessException {
		try {
			return teamDaoService.getTeamByProjectID(projectID);
		} catch (DataAccessException e) {
			throw new DataAccessException(e.getMessage());
		} catch (TeamNotFoundException e) {
			throw new TeamNotFoundException(e.getMessage());
		}
	}

	@Override
	public Set<User> getTeamMembersByProjectID(int projectID) throws DataAccessException {
		try {
			return teamDaoService.getTeamMembersByProjectID(projectID);
		} catch (DataAccessException e) {
			throw new DataAccessException(e.getMessage());
		} catch (ClassNotFoundException e) {
			throw new DataAccessException(e.getMessage());
		} catch (SQLException e) {
			throw new DataAccessException(e.getMessage());
		}
	}

}
