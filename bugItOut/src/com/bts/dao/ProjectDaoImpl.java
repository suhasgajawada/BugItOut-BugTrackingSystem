/**
 * 
 */
package com.bts.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
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
public class ProjectDaoImpl implements com.bts.dao.ProjectDao {

	@Override
	public void createProject(Project project) throws DataAccessException {
		// TODO Auto-generated method stub
		// Establish a database connection
		Connection con = null;
		try{
			con = com.bts.dao.util.DbConnection.getConnection();
		}
		catch (ClassNotFoundException | SQLException e){
			throw new DataAccessException(e);
		}

//		Define the SQL query to insert a new project
		String sqlQuery ="INSERT INTO projects values(?, ?, ?, ?, ?)";
		try{
//			create a prepared statement
			PreparedStatement preparedStatement = con.prepareStatement(sqlQuery);

//			Set the values for the parameters in query
			preparedStatement.setInt(1, project.getProjectId());
			preparedStatement.setString(2, project.getProjectName());
			preparedStatement.setString(3, project.getDescription());
			LocalDate date = project.getStartDate().now();
			LocalDateTime datetime = date.atStartOfDay();
			preparedStatement.setTimestamp(4, java.sql.Timestamp.valueOf(datetime));
			preparedStatement.setString(5, project.getStatus().name());

//			Executing the query
			int rowsAffected = preparedStatement.executeUpdate();

			if(rowsAffected != 1){
				throw new DataAccessException();
			}

//			Close the prepared statement
			preparedStatement.close();
			con.close();
		}
		catch(SQLException e){
			throw new DataAccessException(e);
		}

	}

	@Override
	public Project getProjectById(int projectId) throws ProjectNotFoundException, DataAccessException {
		// TODO Auto-generated method stub
		Connection con = null;
		try{
			con = com.bts.dao.util.DbConnection.getConnection();
		}
		catch (ClassNotFoundException | SQLException e){
			throw new DataAccessException(e);
		}
		String sqlQuery ="INSERT INTO projects WHERE projectId = ?";
		Project project = null;
		try{
//			create a prepared statement
			PreparedStatement preparedStatement = con.prepareStatement(sqlQuery);
			preparedStatement.setInt(1, projectId);
			ResultSet resultSet = preparedStatement.executeQuery();

			while(resultSet.next()){
				project = new Project();
				project.setProjectId(resultSet.getInt("projectId"));
				project.setProjectName(resultSet.getString("projectName"));
				project.setDescription(resultSet.getString("description"));
				project.setStartDate(resultSet.getTimestamp("startDate").toLocalDateTime().toLocalDate());
				project.setStatus(Status.valueOf(resultSet.getString("status")));
			}
//			Executing the query
			int rowsAffected = preparedStatement.executeUpdate();

			if(rowsAffected != 1){
				throw new DataAccessException();
			}

//			Close the prepared statement
			preparedStatement.close();
			con.close();
		}
		catch(SQLException e){
			throw new DataAccessException(e);
		}
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
