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
	public void createBug(Bug bug) throws DataAccessException {
		// TODO Auto-generated method stub

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
