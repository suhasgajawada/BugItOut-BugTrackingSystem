/**
 * 
 */
package com.bts.beans;

import java.util.Objects;

import com.bts.beans.enums.UserType;

/**
 * 
 */
public class User {
	private int userId;
	private String name;
	private String email;
	private UserType userType;
	private String password;
	private boolean loggedIn;
	/**
	 * @param userId
	 * @param name
	 * @param email
	 * @param userType
	 * @param password
	 */
	public User(int userId, String name, String email, UserType userType, String password,boolean loggedIn) {
		super();
		this.userId = userId;
		this.name = name;
		this.email = email;
		this.userType = userType;
		this.password = password;
		this.loggedIn = loggedIn;
	}
	// setters , getters and overriding toString methodd
	@Override
	public String toString() {
		return "User [userId=" + userId + ", name=" + name + ", email=" + email + ", userType=" + userType
				+ ", password=" + password + ", loggedIn=" + loggedIn + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(userId);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return userId == other.userId;
	}
	public boolean isLoggedIn() {
		return loggedIn;
	}
	public void setLoggedIn(boolean loggedIn) {
		this.loggedIn = loggedIn;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public UserType getUserType() {
		return userType;
	}
	public void setUserType(UserType userType) {
		this.userType = userType;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * 
	 */
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

}
