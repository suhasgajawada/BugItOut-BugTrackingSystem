/**
 * 
 */
package com.bts.service;

import java.util.Set;

import com.bts.beans.Bug;
import com.bts.dao.BugDao;
import com.bts.exceptions.AuthorizationException;
import com.bts.exceptions.BugAssignmentException;
import com.bts.exceptions.BugNotFoundException;
import com.bts.exceptions.DataAccessException;
import com.bts.exceptions.InvalidDataException;
import com.bts.util.ObjectFactory;

/**
 * 
 */
public class BugServiceImpl implements BugService {
	

	/**
	 * 
	 */
	BugDao bugDaoService = null;
	public BugServiceImpl() {
		bugDaoService = ObjectFactory.getBugDaoInstance();
	}

	@Override
	public void createBug(Bug bug) throws DataAccessException, InvalidDataException {
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
	public void assignBugToDeveloper(int bugID, int developerID)
			throws BugAssignmentException, DataAccessException, AuthorizationException {
		// TODO Auto-generated method stub

	}

	@Override
	public void markBugForClosing(int bugID)
			throws BugAssignmentException, DataAccessException, AuthorizationException {
		// TODO Auto-generated method stub

	}

	@Override
	public void closeBug(int bugID, int projectManagerID)
			throws BugAssignmentException, DataAccessException, AuthorizationException {
		// TODO Auto-generated method stub

	}

	@Override
	public Set<Bug> getBugsAssignedToDeveloper(int developerID) throws DataAccessException {
		// TODO Auto-generated method stub
		return null;
	}

}
