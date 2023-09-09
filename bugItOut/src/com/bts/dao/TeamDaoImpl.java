/**
 * 
 */
package com.bts.dao;

import java.util.Set;

import com.bts.beans.Team;
import com.bts.beans.User;
import com.bts.exceptions.DataAccessException;
import com.bts.exceptions.TeamNotFoundException;

/**
 * 
 */
public class TeamDaoImpl implements TeamDao {

	@Override
	public void createTeam(Team team) throws DataAccessException {
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
