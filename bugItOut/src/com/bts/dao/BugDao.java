/**
 * 
 */
package com.bts.dao;

import java.sql.SQLException;
import java.util.Set;

import com.bts.beans.Bug;
import com.bts.exceptions.BugAssignmentException;
import com.bts.exceptions.BugNotFoundException;
import com.bts.exceptions.DataAccessException;

/**
 * 
 */
public interface BugDao {

    void createBug(Bug bug) throws DataAccessException, SQLException, ClassNotFoundException;
    Bug getBugByID(int bugID) throws BugNotFoundException, DataAccessException, ClassNotFoundException, SQLException;
    Set<Bug> getBugsByProjectID(int projectID) throws DataAccessException, SQLException, ClassNotFoundException;
    void assignBugToDeveloper(int bugID, int developerID) throws BugAssignmentException, DataAccessException, SQLException, ClassNotFoundException;
    void markBugForClosing(int bugID) throws BugAssignmentException, DataAccessException, SQLException, ClassNotFoundException;
    void closeBug(int bugID, int projectManagerID) throws BugAssignmentException, DataAccessException, ClassNotFoundException, SQLException;
    Set<Bug> getBugsAssignedToDeveloper(int developerID) throws DataAccessException, SQLException, ClassNotFoundException;

}
