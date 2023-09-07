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
public interface BugDao {

    void createBug(Bug bug) throws DataAccessException;
    Bug getBugByID(int bugID) throws BugNotFoundException, DataAccessException;
    Set<Bug> getBugsByProjectID(int projectID) throws DataAccessException;
    void assignBugToDeveloper(int bugID, int developerID) throws BugAssignmentException, DataAccessException;
    void markBugForClosing(int bugID) throws BugAssignmentException, DataAccessException;
    void closeBug(int bugID, int projectManagerID) throws BugAssignmentException, DataAccessException;
    Set<Bug> getBugsAssignedToDeveloper(int developerID) throws DataAccessException;

}
