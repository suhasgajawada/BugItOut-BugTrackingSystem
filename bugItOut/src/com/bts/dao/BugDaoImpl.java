package com.bts.dao;

import java.security.Timestamp;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import com.bts.beans.Bug;
import com.bts.beans.enums.BugStatus;
import com.bts.beans.enums.Severity;
import com.bts.dao.util.DbConnection;
import com.bts.exceptions.BugAssignmentException;
import com.bts.exceptions.BugNotFoundException;
import com.bts.exceptions.DataAccessException;

/**
 * 
 */
public class BugDaoImpl implements BugDao {
    @Override
	public void createBug(Bug bug) throws DataAccessException, SQLException, ClassNotFoundException {
		   Connection connection = null;
           PreparedStatement preparedStatement = null;
            // Establish a database connection
           try
           {
            connection = DbConnection.getConnection();
           }catch(ClassNotFoundException e) {
        	   throw new ClassNotFoundException();
           }catch(SQLException e) {
        	   throw new SQLException();
           }

            // Prepare the SQL statement for inserting a new bug
            String insertSQL = "INSERT INTO bug (bug_title, bug_description, projectId, created_by, open_date, assigned_to, marked_for_closing, closed_by, closed_on, status, severity) " +
                               "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            try
            {
            preparedStatement = connection.prepareStatement(insertSQL);

            // Set values for the prepared statement
            preparedStatement.setString(1, bug.getTitle());
            preparedStatement.setString(2, bug.getDescription());
            preparedStatement.setInt(3, bug.getProjectId());
            preparedStatement.setInt(4, bug.getCreatedBy());
            LocalDateTime openDateTime = bug.getOpenDate().now();;
            preparedStatement.setTimestamp(5, java.sql.Timestamp.valueOf(openDateTime));
            preparedStatement.setInt(6, bug.getAssignedTo());
            preparedStatement.setBoolean(7, bug.isMarkedForClosing());
            preparedStatement.setInt(8, bug.getClosedBy());
            LocalDate closeDate = bug.getClosedOn();
            LocalDateTime closeDateTime = closeDate.atStartOfDay();
            preparedStatement.setTimestamp(9, java.sql.Timestamp.valueOf(closeDateTime));
            preparedStatement.setString(10, bug.getStatus().name());
            preparedStatement.setString(11, bug.getSeverity().name());
            // Execute the insert statement
            int status = preparedStatement.executeUpdate();
            if(status !=1)
            {
            	throw new DataAccessException();
            }
            //closing the prepared statement.
            preparedStatement.close();
            }
        catch(SQLException e)
        {
        	throw new SQLException(e);
        }finally {
        	connection.close();
        }
 }

	
	@Override
	public Bug getBugByID(int bugID) throws BugNotFoundException, DataAccessException, ClassNotFoundException, SQLException {
		    Connection connection = null;
	        PreparedStatement preparedStatement = null;
	        ResultSet resultSet = null;
             try {
	            connection = DbConnection.getConnection();
             }catch(ClassNotFoundException e) {
          	   throw new ClassNotFoundException();
             }catch(SQLException e) {
          	   throw new SQLException();
             }

	            String selectSQL = "SELECT * FROM bug WHERE bug_id = ?";
	            Bug bug = null;
	            try
	            {
	            preparedStatement = connection.prepareStatement(selectSQL);
	            preparedStatement.setInt(1, bugID);
	            resultSet= preparedStatement.executeQuery();
                   if(resultSet.next()){
	                bug = new Bug();
	                bug.setBugId(resultSet.getInt("bug_id"));
	                bug.setTitle(resultSet.getString("bug_title"));
	                bug.setDescription(resultSet.getString("bug_description"));
	                bug.setProjectId(resultSet.getInt("projectId"));
	                bug.setCreatedBy(resultSet.getInt("created_by"));
	                bug.setOpenDate(resultSet.getTimestamp("open_date").toLocalDateTime());
	                bug.setAssignedTo(resultSet.getInt("assigned_to"));
	                bug.setMarkedForClosing(resultSet.getBoolean("marked_for_closing"));
	                bug.setClosedBy(resultSet.getInt("closed_by"));
	                bug.setClosedOn(resultSet.getTimestamp("closed_on") != null ? resultSet.getTimestamp("closed_on").toLocalDateTime().toLocalDate():null);
	                bug.setStatus(BugStatus.valueOf(resultSet.getString("status")));
	                bug.setSeverity(Severity.valueOf(resultSet.getString("severity")));

	            } else {
	                throw new BugNotFoundException("Bug with ID " + bugID + " not found.");
	            }
	           resultSet.close();
	            preparedStatement.close();
	        } catch (SQLException e) {
	            throw new DataAccessException("Error while fetching bug by ID", e);
	        } finally {
	            connection.close();
	        }
	            return bug;
	    }

	@Override
	public Set<Bug> getBugsByProjectID(int projectID) throws DataAccessException, SQLException, ClassNotFoundException {
		    Connection connection = null;
	        PreparedStatement preparedStatement = null;
	        ResultSet resultSet = null;
	        Set<Bug> bugs = new HashSet<>();

	        try {
	            try {
					connection = DbConnection.getConnection();
				} catch(ClassNotFoundException e) {
		          	   throw new ClassNotFoundException();
	             }catch(SQLException e) {
	          	   throw new SQLException();
	             }

	            String selectSQL = "SELECT * FROM bug WHERE projectId = ?";
	            preparedStatement = connection.prepareStatement(selectSQL);
	            preparedStatement.setInt(1, projectID);

	            resultSet = preparedStatement.executeQuery();

	            while (resultSet.next()) {
	                Bug bug = new Bug();
	                bug.setBugId(resultSet.getInt("bug_id"));
	                bug.setTitle(resultSet.getString("bug_title"));
	                bug.setDescription(resultSet.getString("bug_description"));
	                bug.setProjectId(resultSet.getInt("projectId"));
	                bug.setCreatedBy(resultSet.getInt("created_by"));
	                bug.setOpenDate(resultSet.getTimestamp("open_date").toLocalDateTime());
	                bug.setAssignedTo(resultSet.getInt("assigned_to"));
	                bug.setMarkedForClosing(resultSet.getBoolean("marked_for_closing"));
	                bug.setClosedBy(resultSet.getInt("closed_by"));
	                bug.setClosedOn(resultSet.getTimestamp("closed_on") != null ?
	                                resultSet.getTimestamp("closed_on").toLocalDateTime().toLocalDate() :
	                                null);
	                bug.setStatus(BugStatus.valueOf(resultSet.getString("status")));
	                bug.setSeverity(Severity.valueOf(resultSet.getString("severity")));

	                bugs.add(bug);
	            }

	            return bugs;
	        } catch (SQLException e) {
	            throw new DataAccessException("Error while fetching bugs by project ID", e);
	        } finally {
	            connection.close();
	        }
	}

	@Override
	public void assignBugToDeveloper(int bugID, int developerID) throws BugAssignmentException, DataAccessException, SQLException, ClassNotFoundException {
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

	            // Check if the bug with the specified bugID exists
	            String checkBugSQL = "SELECT bug_id FROM bug WHERE bug_id = ?";
	            preparedStatement = connection.prepareStatement(checkBugSQL);
	            preparedStatement.setInt(1, bugID);
	            ResultSet resultSet = preparedStatement.executeQuery();

	            if (resultSet.next()) {
	                // The bug with the specified bugID exists, so we can proceed with assignment
	                String assignBugSQL = "UPDATE bug SET assigned_to = ? WHERE bug_id = ?";
	                preparedStatement = connection.prepareStatement(assignBugSQL);
	                preparedStatement.setInt(1, developerID);
	                preparedStatement.setInt(2, bugID);

	                int updatedRows = preparedStatement.executeUpdate();

	                if (updatedRows == 0) {
	                    throw new BugAssignmentException("Bug with ID " + bugID + " not found.");
	                }
	            } else {
	                throw new BugAssignmentException("Bug with ID " + bugID + " not found.");
	            }
	        } catch (SQLException e) {
	            throw new DataAccessException("Error while assigning bug to developer", e);
	        } finally {
	            connection.close();
	        }
	    }

	@Override
	public void markBugForClosing(int bugID) throws BugAssignmentException, DataAccessException, SQLException, ClassNotFoundException {
		Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            try {
				connection = DbConnection.getConnection();
			}catch(ClassNotFoundException e) {
	          	   throw new ClassNotFoundException();
          }catch(SQLException e) {
       	   throw new SQLException();
          }

            // Check if the bug with the specified bugID exists
            String checkBugSQL = "SELECT bug_id FROM bug WHERE bug_id = ?";
            preparedStatement = connection.prepareStatement(checkBugSQL);
            preparedStatement.setInt(1, bugID);
            if (!preparedStatement.executeQuery().next()) {
                throw new BugAssignmentException("Bug with ID " + bugID + " not found.");
            }

            // Mark the bug for closing by updating the marked_for_closing column
            String markBugSQL = "UPDATE bug SET marked_for_closing = 1 WHERE bug_id = ?";
            preparedStatement = connection.prepareStatement(markBugSQL);
            preparedStatement.setInt(1, bugID);

            int updatedRows = preparedStatement.executeUpdate();

            if (updatedRows == 0) {
                throw new BugAssignmentException("Failed to mark Bug with ID " + bugID + " for closing.");
            }
        } catch (SQLException e) {
            throw new DataAccessException("Error while marking bug for closing", e);
        } finally {
           connection.close();
        }
 }


	@Override
	public void closeBug(int bugID, int projectManagerID) throws BugAssignmentException, DataAccessException, ClassNotFoundException, SQLException {
		Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = DbConnection.getConnection();
		   }catch(ClassNotFoundException e) {
       	      throw new ClassNotFoundException();
           }catch(SQLException e) {
	           throw new SQLException();
            }

            // Check if the bug with the specified bugID exists
            String checkBugSQL = "SELECT bug_id FROM bug WHERE bug_id = ?";
            try {
            preparedStatement = connection.prepareStatement(checkBugSQL);
            preparedStatement.setInt(1, bugID);
            if (!preparedStatement.executeQuery().next()) {
                throw new BugAssignmentException("Bug with ID " + bugID + " not found.");
            }

            // Close the bug by updating the closed_by and closed_on columns
            String closeBugSQL = "UPDATE bug SET closed_by = ?, closed_on = ?, marked_for_closing = 1 WHERE bug_id = ?";
            preparedStatement = connection.prepareStatement(closeBugSQL);
            preparedStatement.setInt(1, projectManagerID);
            preparedStatement.setTimestamp(2, java.sql.Timestamp.valueOf(LocalDateTime.now()));
            preparedStatement.setInt(3, bugID);

            int updatedRows = preparedStatement.executeUpdate();

            if (updatedRows == 0) {
                throw new BugAssignmentException("Failed to close Bug with ID " + bugID + ".");
            }
        } catch (SQLException e) {
            throw new DataAccessException("Error while closing bug", e);
        } finally {
            connection.close();
        }
    }

	@Override
	public Set<Bug> getBugsAssignedToDeveloper(int developerID) throws DataAccessException, SQLException, ClassNotFoundException {
		Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Set<Bug> bugs = new HashSet<>();

        try {
            try {
				connection = DbConnection.getConnection();
			} catch(ClassNotFoundException e) {
	       	      throw new ClassNotFoundException();
	           }catch(SQLException e) {
		           throw new SQLException();
	            }

            String selectSQL = "SELECT * FROM bug WHERE assigned_to = ?";
            preparedStatement = connection.prepareStatement(selectSQL);
            preparedStatement.setInt(1, developerID);

            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Bug bug = new Bug();
                bug.setBugId(resultSet.getInt("bug_id"));
                bug.setTitle(resultSet.getString("bug_title"));
                bug.setDescription(resultSet.getString("bug_description"));
                bug.setProjectId(resultSet.getInt("projectId"));
                bug.setCreatedBy(resultSet.getInt("created_by"));
                bug.setOpenDate(resultSet.getTimestamp("open_date").toLocalDateTime());
                bug.setAssignedTo(resultSet.getInt("assigned_to"));
                bug.setMarkedForClosing(resultSet.getBoolean("marked_for_closing"));
                bug.setClosedBy(resultSet.getInt("closed_by"));
                bug.setClosedOn(resultSet.getTimestamp("closed_on") != null ?
                                resultSet.getTimestamp("closed_on").toLocalDateTime().toLocalDate() :
                                null);
                bug.setStatus(BugStatus.valueOf(resultSet.getString("status")));
                bug.setSeverity(Severity.valueOf(resultSet.getString("severity")));

                bugs.add(bug);
            }

            return bugs;
        } catch (SQLException e) {
            throw new DataAccessException("Error while fetching bugs assigned to developer", e);
        } finally {
            connection.close();
        }
    }
}
