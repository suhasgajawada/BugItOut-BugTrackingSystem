/**
 * 
 */
package com.bts.dao;

import java.sql.SQLException;
import java.util.Set;

import com.bts.beans.Team;
import com.bts.beans.User;
import com.bts.exceptions.DataAccessException;
import com.bts.exceptions.TeamNotFoundException;

/**
 * 
 */
public interface TeamDao {
    void createTeam(Team team) throws DataAccessException, SQLException, ClassNotFoundException;
    Team getTeamByID(int teamID) throws TeamNotFoundException, DataAccessException; //not required
    Team getTeamByProjectID(int projectID) throws TeamNotFoundException, DataAccessException; //not required
    Set<User> getTeamMembersByProjectID(int projectID) throws DataAccessException, SQLException, ClassNotFoundException;
    public void addDevlopersToTeam(int developerId,int projectId) throws DataAccessException;

}
