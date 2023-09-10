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

public class BugServiceImpl implements BugService {
	static BugDao bugDaoService = ObjectFactory.getBugDaoInstance();
	
	@Override
    public void createBug(Bug bug) throws DataAccessException, InvalidDataException {
        // Create the bug
        bugDaoService.createBug(bug);
    }


	@Override
	public Bug getBugByID(int bugID) throws BugNotFoundException, DataAccessException {
		try {
			return bugDaoService.getBugByID(bugID);
		} catch (BugNotFoundException e) {
			throw new BugNotFoundException(e.getMessage());
		} catch (DataAccessException e) {
			throw new DataAccessException(e.getMessage());
		}
	}

	@Override
	public Set<Bug> getBugsByProjectID(int projectID) throws DataAccessException {
		try {
			return bugDaoService.getBugsByProjectID(projectID);
		} catch (DataAccessException e) {
			throw new DataAccessException(e.getMessage());
		}
	}

	@Override
	public void assignBugToDeveloper(int bugID, int developerID)
			throws BugAssignmentException, DataAccessException {
		try {
			bugDaoService.assignBugToDeveloper(bugID, developerID);
		}catch (DataAccessException e) {
			throw new DataAccessException(e.getMessage());
		}catch (BugAssignmentException e) {
			throw new BugAssignmentException(e.getMessage());
		}
	}

	@Override
	public void markBugForClosing(int bugID)
			throws BugAssignmentException, DataAccessException {
		try {
			bugDaoService.markBugForClosing(bugID);
		} catch (BugAssignmentException e) {
			throw new BugAssignmentException(e.getMessage());
		}
		catch (DataAccessException e) {
			throw new DataAccessException(e.getMessage());
		}
	}

	@Override
	public void closeBug(int bugID, int projectManagerID)
			throws BugAssignmentException, DataAccessException {
		try {
			bugDaoService.closeBug(bugID, projectManagerID);;
		} catch (BugAssignmentException e) {
			throw new BugAssignmentException(e.getMessage());
		}
		catch (DataAccessException e) {
			throw new DataAccessException(e.getMessage());
		}
	}

	@Override
	public Set<Bug> getBugsAssignedToDeveloper(int developerID) throws DataAccessException {
		try {
			return bugDaoService.getBugsAssignedToDeveloper(developerID);
		} catch (DataAccessException e) {
			throw new DataAccessException(e.getMessage());
		}
	}

}
