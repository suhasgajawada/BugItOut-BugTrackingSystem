/**
 * 
 */
package com.bts.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

import com.bts.beans.Team;
import com.bts.beans.User;
import com.bts.beans.enums.UserType;
import com.bts.dao.util.DbConnection;
import com.bts.exceptions.DataAccessException;
import com.bts.exceptions.TeamNotFoundException;

/**
 * 
 */
public class TeamDaoImpl implements TeamDao {

	@Override
	public void createTeam(Team team) throws DataAccessException, SQLException, ClassNotFoundException {
		Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            try {
				connection = DbConnection.getConnection();
			} catch(ClassNotFoundException e) {
	        	   throw new ClassNotFoundException();
	           }catch(SQLException e) {
	        	   throw new SQLException();
	           }

            String insertSQL = "INSERT INTO team_members (userId, projectId) VALUES (?, ?)";
            preparedStatement = connection.prepareStatement(insertSQL);
            preparedStatement.setInt(1, team.getUserId());
            preparedStatement.setInt(2, team.getProjectId());

            int affectedRows = preparedStatement.executeUpdate();

            if (affectedRows == 0) {
                throw new DataAccessException("Failed to create a new team record.");
            }
        } catch (SQLException e) {
            throw new DataAccessException("Error while creating a new team", e);
        } finally {
            connection.close();
        }
    }

	@Override
	public Team getTeamByID(int teamID) throws TeamNotFoundException, DataAccessException {
		// this method is not required.
		return null;
	}

	@Override
	public Team getTeamByProjectID(int projectID) throws TeamNotFoundException, DataAccessException {
		// this method is not required.
		return null;
	}

	@Override
	public Set<User> getTeamMembersByProjectID(int projectID) throws DataAccessException, SQLException, ClassNotFoundException {
	    Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Set<User> teamMembers = new HashSet<>();

        try {
            try {
				connection = DbConnection.getConnection();
			}catch(ClassNotFoundException e) {
	        	   throw new ClassNotFoundException();
	           }catch(SQLException e) {
	        	   throw new SQLException();
	           }
            String selectSQL = "SELECT u.* FROM users u " +
                               "INNER JOIN team_members t ON u.userId = t.userId " +
                               "WHERE t.projectId = ?";
            preparedStatement = connection.prepareStatement(selectSQL);
            preparedStatement.setInt(1, projectID);

            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                User user = new User();
                user.setUserId(resultSet.getInt("userId"));
                user.setName(resultSet.getString("name"));
                user.setEmail(resultSet.getString("email"));
                user.setLoggedIn(resultSet.getBoolean("loggedIn"));
                user.setUserType(UserType.valueOf(resultSet.getString("userType")));
                teamMembers.add(user);
            }

            return teamMembers;
        } catch (SQLException e) {
            throw new DataAccessException("Error while fetching team members by project ID", e);
        } finally {
           connection.close();
        }
	}

}
