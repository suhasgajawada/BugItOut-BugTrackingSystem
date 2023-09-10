/**
 * 
 */
package com.bts.dao;

import java.util.Set;

import com.bts.beans.User;
import com.bts.exceptions.AuthenticationException;
import com.bts.exceptions.DataAccessException;
import com.bts.exceptions.UserAlreadyExistsException;
import com.bts.exceptions.UserNotFoundException;

/**
 * 
 */
public class UserDaoImpl implements UserDao {

	@Override
	public void createUser(User user) throws DataAccessException ,UserAlreadyExistsException {
		// TODO Auto-generated method stub

	}

	@Override
	public User getUserById(int userId) throws UserNotFoundException, DataAccessException {
		// TODO Auto-generated method stub
		User user= null;
		return user;
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
	public void logoutUser(int userId) throws DataAccessException {
		// user.setLastLogoutTime(LocalDateTime.now());

	}

	@Override
	public void updateUserPassword(int userId, String newPassword) throws DataAccessException {
		// TODO Auto-generated method stub

	}

	@Override
	public Set<User> getAllUsers() throws DataAccessException {
		// TODO Auto-generated method stub
		return null;
	}

}
