/**
 * 
 */
package com.bts.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import com.bts.beans.Bug;
import com.bts.beans.Project;
import com.bts.beans.Team;
import com.bts.beans.enums.BugStatus;
import com.bts.beans.enums.ProjectStatus;
import com.bts.dao.util.DbConnection;
import com.bts.exceptions.DataAccessException;
import com.bts.exceptions.ProjectNotFoundException;
import com.bts.exceptions.TeamNotFoundException;

/**
 * 
 */
public class ProjectDaoImpl implements com.bts.dao.ProjectDao {

	@Override
	public void createProject(Project project) throws DataAccessException {
		// Establish a database connection
		Connection con;
		try {
			con = DbConnection.getConnection();
		} catch (ClassNotFoundException | SQLException e) {
			throw new DataAccessException("Unable to access Data");
		}

//		Define the SQL query to insert a new project
		String sqlQuery = "INSERT INTO projects(projectManagerId ,projectName,description,startDate,status) values(?,?,?, ?, ?)";
		try {
//			create a prepared statement
			PreparedStatement preparedStatement = con.prepareStatement(sqlQuery);

//			Set the values for the parameters in query
			preparedStatement.setInt(1, project.getUserId());
			preparedStatement.setString(2, project.getProjectName());
			preparedStatement.setString(3, project.getDescription());
			project.getStartDate();
			LocalDate date = LocalDate.now();

			preparedStatement.setDate(4, Date.valueOf(date));
			preparedStatement.setString(5, project.getStatus().name());

//			Executing the query
			int rowsAffected = preparedStatement.executeUpdate();

			if (rowsAffected != 1) {
				throw new DataAccessException("Values not stored");
			}

//			Close the prepared statement
			preparedStatement.close();
			con.close();
		} catch (SQLException e) {
			throw new DataAccessException("Data Access Exception");
		}

	}

	@Override
	public Project getProjectById(int projectId) throws ProjectNotFoundException, DataAccessException {
		// TODO Auto-generated method stub
		Connection con = null;
		try {
			con = DbConnection.getConnection();
		} catch (ClassNotFoundException | SQLException e) {
			throw new DataAccessException(e);
		}
		String sqlQuery = "SELECT * FROM projects WHERE projectId = ?";
		Project project = null;
		try {
//			create a prepared statement
			PreparedStatement preparedStatement = con.prepareStatement(sqlQuery);
			preparedStatement.setInt(1, projectId);
			ResultSet resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				project = new Project();
				project.setUserId(resultSet.getInt("projectManagerId"));
				project.setProjectId(projectId);
				project.setProjectName(resultSet.getString("projectName"));
				project.setDescription(resultSet.getString("description"));
				project.setStartDate(resultSet.getTimestamp("startDate").toLocalDateTime().toLocalDate());
				project.setStatus(ProjectStatus.valueOf(resultSet.getString("status")));
			} else {
				throw new ProjectNotFoundException("Project with ID " + projectId + " not found");
			}

			resultSet.close();
			preparedStatement.close();
			con.close();
		} catch (SQLException e) {
			throw new DataAccessException("Unable to access Data");
		}
		return project;
	}

	@Override
	public Set<Project> getAllProjects() throws DataAccessException {
		Set<Project> projects = new HashSet<>();

		Connection con = null;
		try {
			con = DbConnection.getConnection();
		} catch (ClassNotFoundException | SQLException e) {
			throw new DataAccessException(e);
		}
		String sqlQuery = "SELECT * FROM projects";
		try {
			PreparedStatement preparedStatement = con.prepareStatement(sqlQuery);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				int projectManagerId = resultSet.getInt("projectMangaerid");
				int projectId = resultSet.getInt("projectId");
				String projectName = resultSet.getString("projectName");
				String description = resultSet.getString("description");
				LocalDate startDate = resultSet.getDate("startDate").toLocalDate();
				ProjectStatus status = ProjectStatus.valueOf(resultSet.getString("status"));

				Project project = new Project(projectManagerId, projectId, projectName, description, startDate, status);
				projects.add(project);
			}
		} catch (SQLException e) {
			throw new DataAccessException(e);
		}

		return projects;
	}

	@Override
	public Set<Project> getProjectsManagedByUser(int projectManagerId) throws DataAccessException {
		Set<Project> projects = new HashSet<>();
		Connection con = null;
		try {
			con = DbConnection.getConnection();
		} catch (ClassNotFoundException | SQLException e) {
			throw new DataAccessException(e);
		}
		String sqlQuery = "SELECT * FROM projects WHERE projectManagerId = ?";
		try {
			PreparedStatement preparedStatement = con.prepareStatement(sqlQuery);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				int projectManagerId1 = projectManagerId;
				int projectId = resultSet.getInt("projectId");
				String projectName = resultSet.getString("projectName");
				String description = resultSet.getString("description");
				LocalDate startDate = resultSet.getDate("startDate").toLocalDate();
				ProjectStatus status = ProjectStatus.valueOf(resultSet.getString("status"));

				Project project = new Project(projectManagerId1, projectId, projectName, description, startDate,
						status);
				projects.add(project);
			}
		} catch (SQLException e) {
			throw new DataAccessException(e);
		}
		return projects;
	}

	@Override
	public Set<Team> getProjectTeam(int projectId) throws TeamNotFoundException, DataAccessException {
		// TODO Auto-generated method stub
		Set<Team> team = new HashSet<>();
		Connection con = null;
		try {
			con = DbConnection.getConnection();
		} catch (ClassNotFoundException | SQLException e) {
			throw new DataAccessException(e);
		}
		String sqlQuery = "SELECT * FROM team_members WHERE projectId = ?";
		try {
			PreparedStatement preparedStatement = con.prepareStatement(sqlQuery);
			preparedStatement.setInt(1, projectId);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (!resultSet.next()) {
				throw new TeamNotFoundException("Team with ID " + projectId + " not found");

			}
			do {
				team.add(new Team(resultSet.getInt("userId"), resultSet.getInt("projectId")));

			} while (resultSet.next());

			resultSet.close();
			preparedStatement.close();
			con.close();
		} catch (SQLException e) {
			throw new DataAccessException(e);
		}
		return team;
	}

}