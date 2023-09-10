package com.bts.beans;

import java.util.Objects;

public class Team {
	private int teamId;
	private int projectId;
	private int userId;
	public Team(int teamId, int projectId, int userId) {
		super();
		this.teamId = teamId;
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
	public int getTeamId() {
		return teamId;
	}
	/**
	 * @param teamId the teamId to set
	 */
	public void setTeamId(int teamId) {
		this.teamId = teamId;
	}
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
		final int prime = 31;
		int result = 1;
		result = prime * result + teamId;
		return result;
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
		if (teamId != other.teamId)
			return false;
		return true;
	}
	
	
}