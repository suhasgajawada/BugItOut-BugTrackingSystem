package com.bts.beans;

import java.util.Objects;

public class Team {
	private int teamId;
	private int projectId;// dont know how to give 
	//foreign key reference to Project , https://hellokoding.com/jpa-one-to-one-foreignkey-relationship-
	//example-with-spring-boot-maven-and-mysql/HELPPPPP!
	private int projectManagerId;
	private int testerId;
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
	 * @return the projectManagerId
	 */
	public int getProjectManagerId() {
		return projectManagerId;
	}
	/**
	 * @param projectManagerId the projectManagerId to set
	 */
	public void setProjectManagerId(int projectManagerId) {
		this.projectManagerId = projectManagerId;
	}
	/**
	 * @return the testerId
	 */
	public int getTesterId() {
		return testerId;
	}
	/**
	 * @param testerId the testerId to set
	 */
	public void setTesterId(int testerId) {
		this.testerId = testerId;
	}
	/**
	 * @param teamId
	 * @param projectId
	 * @param projectManagerId
	 * @param testerId
	 */
	public Team(int teamId, int projectId, int projectManagerId, int testerId) {
		super();
		this.teamId = teamId;
		this.projectId = projectId;
		this.projectManagerId = projectManagerId;
		this.testerId = testerId;
	}
	@Override
	public String toString() {
		return "Team [teamId=" + teamId + ", projectId=" + projectId + ", projectManagerId=" + projectManagerId
				+ ", testerId=" + testerId + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(teamId);
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
		return teamId == other.teamId;
	}
}