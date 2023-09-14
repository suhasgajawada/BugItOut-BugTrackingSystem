/**
 * 
 */
package com.bts.service;

import java.util.Set;

import com.bts.beans.User;
import com.bts.beans.enums.UserType;
import com.bts.exceptions.AuthenticationException;
import com.bts.exceptions.DataAccessException;
import com.bts.exceptions.InvalidDataException;
import com.bts.exceptions.UserAlreadyExistsException;
import com.bts.exceptions.UserAlreadyRegisteredException;
import com.bts.exceptions.UserNotFoundException;

/**
 * 
 */
public interface UserService {

    void createUser(User user) throws DataAccessException, InvalidDataException, UserAlreadyExistsException;
    User getUserById(int userID) throws UserNotFoundException, DataAccessException;
    User getUserByEmail(String email) throws UserNotFoundException, DataAccessException;
    User loginUser(String email, String password) throws AuthenticationException, DataAccessException;
    void logoutUser(int userID) throws DataAccessException, AuthenticationException;
    void updateUserPassword(String email, String newPassword) throws DataAccessException, InvalidDataException;
    Set<User> getAllUsers() throws DataAccessException;
	void registerUser(String email, String password, UserType userType)
			throws UserAlreadyRegisteredException, DataAccessException, UserNotFoundException, InvalidDataException;

}
