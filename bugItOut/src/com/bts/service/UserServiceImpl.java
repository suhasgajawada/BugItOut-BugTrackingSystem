/**
 * 
 */
package com.bts.service;

import java.util.Set;

import com.bts.beans.User;
import com.bts.dao.UserDao;
import com.bts.exceptions.AuthenticationException;
import com.bts.exceptions.DataAccessException;
import com.bts.exceptions.InvalidDataException;
import com.bts.exceptions.UserAlreadyExistsException;
import com.bts.exceptions.UserNotFoundException;
import com.bts.util.ObjectFactory;

/**
 * 
 */
public class UserServiceImpl implements UserService {

	/**
	 * 
	 */
	public UserServiceImpl() {
		UserDao userDaoService = ObjectFactory.getUserDaoInstance();
	}

	@Override
	public void createUser(User user) throws DataAccessException, InvalidDataException, UserAlreadyExistsException {
		// TODO Auto-generated method stub

	}

	@Override
	public User getUserByID(int userID) throws UserNotFoundException, DataAccessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User getUserByEmail(String email) throws UserNotFoundException, DataAccessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User loginUser(String email, String password) throws AuthenticationException, DataAccessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void logoutUser(int userID) throws DataAccessException {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateUserPassword(int userID, String newPassword) throws DataAccessException, InvalidDataException {
		// TODO Auto-generated method stub

	}

	@Override
	public Set<User> getAllUsers() throws DataAccessException {
		// TODO Auto-generated method stub
		return null;
	}

}
