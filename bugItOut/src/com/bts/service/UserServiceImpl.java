/**
 * 
 */
package com.bts.service;

import java.util.HashSet;
import java.util.Set;

import com.bts.beans.User;
import com.bts.dao.UserDao;
import com.bts.exceptions.AuthenticationException;
import com.bts.exceptions.DataAccessException;
import com.bts.exceptions.InvalidDataException;
import com.bts.exceptions.UserAlreadyExistsException;
import com.bts.exceptions.UserAlreadyRegisteredException;
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
	public void createUser(User user) throws DataAccessException, InvalidDataException, UserAlreadyExistsException {
		try {
			userDaoService.createUser(user);
		} catch (DataAccessException e) {
			throw new DataAccessException(e);
		} catch(UserAlreadyExistsException e) {
			throw new UserAlreadyExistsException(e);
		}

	}

	@Override

	public User getUserById(int userId) throws UserNotFoundException, DataAccessException {
		User userById = null;
		try {
			userById=userDaoService.getUserById(userId);
		}catch(UserNotFoundException e ) {
			throw new UserNotFoundException(e);
		}catch(DataAccessException e) {
			throw new DataAccessException(e);
		}
		return userById;
	}

	@Override
	public User getUserByEmail(String email) throws UserNotFoundException, DataAccessException {
		User user= null;
		
		try {
			user= userDaoService.getUserByEmail(email);
			
		}catch(UserNotFoundException e) {
			throw new UserNotFoundException(e);
		}catch(DataAccessException e) {
			throw new DataAccessException(e);
		}
		return user;
	}

	@Override
	public User loginUser(String email, String password) throws AuthenticationException, DataAccessException {
		User user =null;
		try{
			user =userDaoService.loginUser(email, password);
		}catch(AuthenticationException e) {
			throw new AuthenticationException(e.getMessage(),e);
		}catch(DataAccessException e) {
			throw new DataAccessException(e.getMessage(),e);
		}
		return user;
	}
		

	@Override
	public void logoutUser(int userID) throws DataAccessException, AuthenticationException {
		try {
			userDaoService.logoutUser(userID);
		}catch (DataAccessException e) {
			throw new DataAccessException(e.getMessage(),e);
		}catch(AuthenticationException e) {
			throw new AuthenticationException(e.getMessage(), e);
		}
	}

	@Override
	public void updateUserPassword(String email, String newPassword) throws DataAccessException, InvalidDataException {
		try {
			userDaoService.updateUserPassword(email, newPassword);
		} catch (DataAccessException  e) {
			throw new DataAccessException(e.getMessage(),e);		}
	}

	@Override
	public Set<User> getAllUsers() throws DataAccessException {
		Set<User> users= new HashSet<>();
		try {
			users = userDaoService.getAllUsers();
		}catch(DataAccessException e) {
			throw new DataAccessException(e.getMessage(),e);
		}
		return users;
	}

	@Override
	public void registerUser(String email, String password) throws UserAlreadyRegisteredException, DataAccessException, UserNotFoundException {
		try {
			userDaoService.registerUser(email, password);
		}catch(UserAlreadyRegisteredException e) {
		
			throw new UserAlreadyRegisteredException(e.getMessage(),e);
		}catch(DataAccessException e) {
			throw new DataAccessException(e.getMessage(),e);
		}catch(UserNotFoundException e) {
			throw new UserNotFoundException(e.getMessage(),e);
		}
		
	}

}
