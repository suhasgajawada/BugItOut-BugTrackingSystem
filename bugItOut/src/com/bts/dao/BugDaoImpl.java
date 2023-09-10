/**
 * 
 */
package com.bts.dao;

import java.util.Set;

import com.bts.beans.Bug;
import com.bts.exceptions.BugAssignmentException;
import com.bts.exceptions.BugNotFoundException;
import com.bts.exceptions.DataAccessException;

/**
 * 
 */
public class BugDaoImpl implements BugDao {

	@Override
	public void createBug(Bug bug) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            // Establish a database connection
            connection = DriverManager.getConnection(JDBC_URL, JDBC_USERNAME, JDBC_PASSWORD);

            // Prepare the SQL statement for inserting a new bug
            String insertSQL = "INSERT INTO bug (bug_title, bug_description, projectId, created_by, open_date, assigned_to, marked_for_closing, closed_by, closed_on, status, severity) " +
                               "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            preparedStatement = connection.prepareStatement(insertSQL);

            // Set values for the prepared statement
            preparedStatement.setString(1, bug.getTitle());
            preparedStatement.setString(2, bug.getDescription());
            preparedStatement.setInt(3, bug.getProjectId());
            preparedStatement.setInt(4, bug.getCreatedBy());
            preparedStatement.setTimestamp(5, Timestamp.valueOf(bug.getOpenDate().atStartOfDay()));
            preparedStatement.setInt(6, bug.getAssignedTo());
            preparedStatement.setBoolean(7, bug.isMarkedForClosing());
            preparedStatement.setInt(8, bug.getClosedBy());
            preparedStatement.setTimestamp(9, bug.getClosedOn() != null ? Timestamp.valueOf(bug.getClosedOn().atStartOfDay()) : null);
            preparedStatement.setString(10, bug.getStatus().toString());
            preparedStatement.setString(11, bug.getSeverity().toString());

            // Execute the insert statement
            preparedStatement.executeUpdate();
        } finally {
            // Close resources
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
    }

	@Override
	public Bug getBugByID(int bugID) throws BugNotFoundException, DataAccessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<Bug> getBugsByProjectID(int projectID) throws DataAccessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void assignBugToDeveloper(int bugID, int developerID) throws BugAssignmentException, DataAccessException {
		// TODO Auto-generated method stub

	}

	@Override
	public void markBugForClosing(int bugID) throws BugAssignmentException, DataAccessException {
		// TODO Auto-generated method stub

	}

	@Override
	public void closeBug(int bugID, int projectManagerID) throws BugAssignmentException, DataAccessException {
		// TODO Auto-generated method stub

	}

	@Override
	public Set<Bug> getBugsAssignedToDeveloper(int developerID) throws DataAccessException {
		// TODO Auto-generated method stub
		return null;
	}

}
