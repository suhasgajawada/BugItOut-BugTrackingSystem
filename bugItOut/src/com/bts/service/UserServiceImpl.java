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
	UserDao userDaoService= null;
	
	public UserServiceImpl() {
		userDaoService = ObjectFactory.getUserDaoInstance();
	}

	@Override
	public void createUser(User user) throws DataAccessException, /*InvalidDataException ,*/ UserAlreadyExistsException {
		try {
			userDaoService.createUser(user);
		} catch (DataAccessException | UserAlreadyExistsException e) {
			e.getMessage();
		}

	}

	@Override
	public User getUserByID(int userId) throws UserNotFoundException, DataAccessException {
		User userById = null;
		try {
			userById=userDaoService.getUserById(userId);
		}catch(UserNotFoundException|DataAccessException e ) {
			e.getMessage();
		}
		return userById;
	}

	@Override
	public User getUserByEmail(String email) throws UserNotFoundException, DataAccessException {
		User userByEmail = null;
		try {
			userByEmail=userDaoService.getUserByEmail(email);
		}catch(UserNotFoundException|DataAccessException e ) {
			e.getMessage();
		}
		return userByEmail;
	}

	@Override
	public User loginUser(String email, String password) throws AuthenticationException, DataAccessException {
		User userLogin = null;
		try {
			userLogin = userDaoService.loginUser(email, password);
		}catch(AuthenticationException | DataAccessException e) {
			e.getMessage();
		}
		return userLogin;
	}

	@Override
	public void logoutUser(int userID) throws DataAccessException {
		try {
			userDaoService.logoutUser(userID);
		} catch (DataAccessException e) {
			e.getMessage();
		}
	}

	@Override
	public void updateUserPassword(int userID, String newPassword) throws DataAccessException, InvalidDataException {
		try {
			userDaoService.updateUserPassword(userID, newPassword);
		} catch (DataAccessException /*| InvalidDataException*/ e) {
			e.getMessage();
		}

	}

	@Override
	public Set<User> getAllUsers() throws DataAccessException {
		Set<User> users = userDaoService.getAllUsers();
		return users;
	}

	@Override
	public void registerUser(String email, String password) {
		// TODO Auto-generated method stub
		
	}


}
