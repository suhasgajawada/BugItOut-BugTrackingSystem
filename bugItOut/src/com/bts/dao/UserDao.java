/**
 * 
 */
package com.bts.dao;

import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.Set;

import com.bts.beans.User;
import com.bts.exceptions.AuthenticationException;
import com.bts.exceptions.DataAccessException;
import com.bts.exceptions.UserAlreadyExistsException;
import com.bts.exceptions.UserNotFoundException;
import com.bts.exceptions.UserAlreadyRegisteredException;

/**
 * 
 */
public interface UserDao {
	void createUser(User user) throws DataAccessException, UserAlreadyExistsException;
	User getUserById(int userId) throws UserNotFoundException,DataAccessException;
	User getUserByEmail(String email) throws UserNotFoundException ,DataAccessException;
	User loginUser(String email,String password) throws AuthenticationException,DataAccessException;
	void logoutUser(int userId) throws DataAccessException, AuthenticationException;
	void updateUserPassword(String email,String newPassword) throws DataAccessException;
	Set<User> getAllUsers() throws DataAccessException;
	void registerUser(String email, String password)throws UserAlreadyRegisteredException,DataAccessException, UserNotFoundException;
}
