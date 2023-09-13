package com.bts.beans;

import java.util.Objects;

public class Team {
	
	private int projectId;
	private int userId;
	public Team( int projectId, int userId) {
		super();
		
		this.projectId = projectId;
		this.userId = userId;
	}
	public Team() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * @return the teamId
	 */
	/**
	 * @return the projectId
	 */
	public int getProjectId() {
		return projectId;
	}
	/**
	 * @param projectId the projectId to set
	 */
	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}
	/**
	 * @param userId the userId to set
	 */
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
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
		Team other = (Team) obj;
		return userId == other.userId;
	}
	@Override
	public String toString() {
		return "Team [userId=" + userId + "]";
	}
	
	
	
}