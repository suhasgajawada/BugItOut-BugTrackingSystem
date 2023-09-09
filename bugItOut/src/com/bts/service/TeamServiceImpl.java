/**
 * 
 */
package com.bts.service;

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
	public TeamServiceImpl() {
		TeamDao teamDaoService = ObjectFactory.getTeamDaoInstance();
	}

	@Override
	public void createTeam(Team team) throws DataAccessException, InvalidDataException, TeamNotFoundException {
		// TODO Auto-generated method stub

	}

	@Override
	public Team getTeamByID(int teamID) throws TeamNotFoundException, DataAccessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Team getTeamByProjectID(int projectID) throws TeamNotFoundException, DataAccessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<User> getTeamMembersByProjectID(int projectID) throws DataAccessException {
		// TODO Auto-generated method stub
		return null;
	}

}
