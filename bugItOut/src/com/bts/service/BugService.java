/**
 * 
 */
package com.bts.service;


import java.util.Set;

import com.bts.beans.Bug;
import com.bts.exceptions.AuthorizationException;
import com.bts.exceptions.BugAssignmentException;
import com.bts.exceptions.BugNotFoundException;
import com.bts.exceptions.DataAccessException;
import com.bts.exceptions.InvalidDataException;

/**
 * 
 */
public interface BugService {
	void createBug(Bug bug) throws DataAccessException, InvalidDataException;
    Bug getBugByID(int bugID) throws BugNotFoundException, DataAccessException;
    Set<Bug> getBugsByProjectID(int projectID) throws DataAccessException;
    void assignBugToDeveloper(int bugID, int developerID) throws BugAssignmentException, DataAccessException, AuthorizationException;
    void markBugForClosing(int bugID) throws BugAssignmentException, DataAccessException, AuthorizationException;
    void closeBug(int bugID, int projectManagerID) throws BugAssignmentException, DataAccessException, AuthorizationException;
    Set<Bug> getBugsAssignedToDeveloper(int developerID) throws DataAccessException;

}
