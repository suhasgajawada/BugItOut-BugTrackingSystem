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
import java.util.Set;

import com.bts.beans.User;
import com.bts.beans.enums.UserType;
import com.bts.dao.util.DbConnection;
import com.bts.exceptions.AuthenticationException;
import com.bts.exceptions.DataAccessException;
import com.bts.exceptions.UserAlreadyExistsException;
import com.bts.exceptions.UserNotFoundException;

/**
 * 
 */
public class UserDaoImpl implements UserDao {
	Connection connection = DbConnection.getConnection();
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
				user = new User(resultSet.getInt("UserId"),resultSet.getString("Name"),
						resultSet.getString("email"),UserType.valueOf(resultSet.getString("userType")));
			}else  {
				throw new UserNotFoundException("User Not Found with Id "+userId);
			}
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
				user = new User(resultSet.getInt("UserId"),resultSet.getString("Name"),
						resultSet.getString("email"),UserType.valueOf(resultSet.getString("userType")));
			}else  {
				throw new UserNotFoundException("User Not Found with email "+email);
			}
		} catch (SQLException e) {
			throw new DataAccessException("Data Access failed ");
		}
		return user;
	}

	

	@Override
	public User loginUser(String email, String password) throws AuthenticationException, DataAccessException {
		User user= null;
		try {
			String sqlQuery = "select*from users where email=? ";
			PreparedStatement statement = connection.prepareStatement(sqlQuery);
			statement.setString(1, email);
			ResultSet resultSet = statement.executeQuery();
			if(resultSet.next()) {
				if(resultSet.getString(4)==null) {
					throw new AuthenticationException("User Not Registered");
				}
				else if(resultSet.getString(4)==password) {
					user = new User(resultSet.getInt(1),resultSet.getString(2),resultSet.getString(3),UserType.valueOf(resultSet.getString(6)));
				}
			}
			else {
				throw new AuthenticationException("Unable to login User");
			}
		} catch (SQLException e) {
				throw new DataAccessException("Unable to Access Data");
		}
		user.setLoggedIn(true);;
		return user;
	}

	@Override
	public void logoutUser(int userId) throws DataAccessException, AuthenticationException{
		
		try {
			String sqlQuery ="select loggedIn from users where userId =?";
			PreparedStatement statment = connection.prepareStatement(sqlQuery);
			statment.setInt(1, userId);
			ResultSet resultSet= statment.executeQuery();
			if(resultSet.getBoolean(1)) {
				String sqlQuery1 = "update users set lastLoginTime = ? where userId =?";
				PreparedStatement statement1 = connection.prepareStatement(sqlQuery1);
				statement1.setTimestamp(1,Timestamp.valueOf(LocalDateTime.now()));
				statement1.setInt(2,userId);
				statement1.executeUpdate();
			}else {
				throw new AuthenticationException("userId invalid");
			}
			
		} catch (SQLException e) {
				throw new DataAccessException("Unable to Access data");
		}

	}

	@Override
	public void updateUserPassword(String email, String newPassword) throws DataAccessException {
		// TODO Auto-generated method stub

	}

	@Override
	public Set<User> getAllUsers() throws DataAccessException {
		// TODO Auto-generated method stub
		return null;
	}

}
