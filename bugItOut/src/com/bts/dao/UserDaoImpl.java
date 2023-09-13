/**
 * 
 */
package com.bts.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import com.bts.beans.User;
import com.bts.beans.enums.UserType;
import com.bts.dao.util.DbConnection;
import com.bts.exceptions.AuthenticationException;
import com.bts.exceptions.DataAccessException;
import com.bts.exceptions.UserAlreadyExistsException;
import com.bts.exceptions.UserAlreadyRegisteredException;
import com.bts.exceptions.UserNotFoundException;

/**
 * 
 */
public class UserDaoImpl implements UserDao {
	Connection connection;
	public UserDaoImpl() throws ClassNotFoundException, SQLException {
		try {
			connection = DbConnection.getConnection();
		} catch (ClassNotFoundException e) {
			throw new ClassNotFoundException(e.getMessage());
		}catch (SQLException e) {
			throw new SQLException(e.getMessage());
		}
	}
	@Override
	public void createUser(User user) throws DataAccessException ,UserAlreadyExistsException {
		PreparedStatement statement = null;
		try {
			String sqlQuery = "insert into users (name,email,userType) values (?,?,?)";
			statement = connection.prepareStatement(sqlQuery);
			statement.setString(1,user.getName());
			statement.setString(2, user.getEmail());
			statement.setString(3, user.getUserType().name());
			statement.executeUpdate();
			
		} catch (SQLIntegrityConstraintViolationException e) {
			throw new UserAlreadyExistsException(" User Already Exists");
		}catch( SQLException e) {
			throw new DataAccessException("Invalid Input");
		}finally {
			try {
				statement.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				throw new DataAccessException("unable to access data");
			}
		}

	}

	@Override
	public User getUserById(int userId) throws UserNotFoundException, DataAccessException {
		// TODO Auto-generated method stub
		User user= null;
		try {
			String sqlQuery = "select * from users where userId= ?";
			PreparedStatement statement = connection.prepareStatement(sqlQuery);
			statement.setInt(1, userId);
			ResultSet resultSet = statement.executeQuery();
			if(resultSet.next()) {
				user = new User(resultSet.getInt(1), resultSet.getString(2),resultSet.getString(3),
						resultSet.getBoolean(5),UserType.valueOf(resultSet.getString(6)));
			
			}else {
				throw new UserNotFoundException("User Not Found with Id "+userId);
			}
			resultSet.close();
			statement.close();
			
		} catch (SQLException e) {
			throw new DataAccessException("Data Access failed ");
		}
		return user;
	}

	@Override
	public User getUserByEmail(String email) throws UserNotFoundException, DataAccessException {
		User user= null;
		try {
			String sqlQuery = "select * from users where email= ?";
			PreparedStatement statement = connection.prepareStatement(sqlQuery);
			statement.setString(1, email);
			ResultSet resultSet = statement.executeQuery();
			if(resultSet.next()) {
				user = new User(resultSet.getInt(1), resultSet.getString(2),resultSet.getString(3),
						resultSet.getBoolean(5),UserType.valueOf(resultSet.getString(6))/*,resultSet.getTimestamp(7).toLocalDateTime()*/);
				user.setPassword(resultSet.getString(4));
			}else  {
				throw new UserNotFoundException("User Not Found with email "+email);
			}
			resultSet.close();
			statement.close();
		} catch (SQLException e) {
			throw new DataAccessException("Data Access failed ");
		}
		return user;
	}

	@Override
	public User loginUser(String email, String password) throws AuthenticationException, DataAccessException {
		User user= null;
		try {
			User userByEmail = getUserByEmail(email);
			if(userByEmail!=null) {
			
				if(userByEmail.getPassword()== null) {
					throw new AuthenticationException("User Not Registered");
				}
				else if(userByEmail.getPassword().equals(password)) {
					user = userByEmail;
					user.setLoggedIn(true);
					String sqlQuery="update users set loggedIn = ? where email = ?";
					PreparedStatement statement = connection.prepareStatement(sqlQuery);
					statement.setBoolean(1, true);
					statement.setString(2, email);
					statement.executeUpdate();
					statement.close();
				}
			}
			else {
				throw new AuthenticationException("Unable to login User");
			}
				
		}catch (SQLException e) {
				throw new DataAccessException("Unable to Access Data");
		}catch(UserNotFoundException e) {
			throw new AuthenticationException("User not imported");
		}
		return user;
	}

	@Override
	public void logoutUser(int userId) throws DataAccessException, AuthenticationException{
		
		try {
			User user = getUserById(userId);
			if(user.isLoggedIn()) {
				String sqlQuery1 = "update users set lastLoginTime = ?, loggedIn = ? where userId =?";
				PreparedStatement statement = connection.prepareStatement(sqlQuery1);
				statement.setTimestamp(1,Timestamp.valueOf(LocalDateTime.now()));
				statement.setBoolean(2, false);
				statement.setInt(3,userId);
				statement.executeUpdate();
				statement.close();
			}else {
				throw new AuthenticationException("userId invalid");
			}
			
		} catch (SQLException e) {
				throw new DataAccessException("Unable to Access data");
		}catch (UserNotFoundException e) {
			throw new AuthenticationException("userId invalid");
		}

	}

	@Override
	public void updateUserPassword(String email, String newPassword) throws DataAccessException {
		try {
			String sqlQuery1 = "update users set password = ? where email =?";
			PreparedStatement statement = connection.prepareStatement(sqlQuery1);
			statement.setString(1,newPassword);
			statement.setString(2, email);
			statement.executeUpdate();
			
			statement.close();
		} catch (SQLException e) {
			throw new DataAccessException("Unable to Access Data");
		}

	}

	@Override
	public Set<User> getAllUsers() throws DataAccessException {
		Set<User> users= new HashSet<>();
		try {
			String sqlQuery = "select * from users";
			PreparedStatement statement = connection.prepareStatement(sqlQuery);
			ResultSet resultSet = statement.executeQuery();
			while(resultSet.next()) {
				users.add(new User(resultSet.getInt(1), resultSet.getString(2),resultSet.getString(3),
						resultSet.getBoolean(5),UserType.valueOf(resultSet.getString(6)), resultSet.getTimestamp("lastLoginTime")));
			}
		} catch (SQLException e) {
			throw new DataAccessException(" Unable to access the data ");
		}
		return users;
	}

	@Override
	public void registerUser(String email, String password) throws UserAlreadyRegisteredException, DataAccessException, UserNotFoundException {
		try {
			User user= getUserByEmail(email);
			if(user.getPassword()!=null) {
				throw  new UserAlreadyRegisteredException("User with email "+email+" already Registored , please proceed to login");
			}else {
				updateUserPassword(email, password);
			}
		} catch (DataAccessException  e) {
				throw new DataAccessException(e);
		}catch(UserNotFoundException e) {
			throw new UserNotFoundException("user not imported with this email "+email);
		}
		
	}

}
