/**
 * 
 */
package com.bts.service;

import java.util.Set;

import com.bts.beans.Team;
import com.bts.beans.User;
import com.bts.exceptions.DataAccessException;
import com.bts.exceptions.InvalidDataException;
import com.bts.exceptions.TeamNotFoundException;

/**
 * 
 */
public interface TeamService {

    void createTeam(Team team) throws DataAccessException, InvalidDataException, TeamNotFoundException;
    Team getTeamByID(int teamID) throws TeamNotFoundException, DataAccessException;
    Team getTeamByProjectID(int projectID) throws TeamNotFoundException, DataAccessException;
    Set<User> getTeamMembersByProjectID(int projectID) throws DataAccessException;

}
