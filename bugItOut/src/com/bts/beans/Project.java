/**
 * 
 */
package com.bts.beans;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Objects;

import com.bts.beans.enums.ProjectStatus;

/**
 * 
 */
public class Project {
	private int userId;
	private int projectId;
	private String projectName;
	private String description;
	private LocalDate startDate;
	private ProjectStatus status;
	public int getProjectId() {
		return projectId;
	}
	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public LocalDate getStartDate() {
		return startDate;
	}
	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}
	public ProjectStatus getStatus() {
		return status;
	}
	public void setStatus(ProjectStatus status) {
		this.status = status;
	}
	@Override
	public int hashCode() {
		return Objects.hash(projectId);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Project other = (Project) obj;
		return projectId == other.projectId;
	}
	/**
	 * @param status2 
	 * @param startDate2 
	 * @param description2 
	 * @param projectName2 
	 * @param projectId2 
	 * 
	 */
	
	/**
	 * @param projectId
	 * @param projectName
	 * @param description
	 * @param startDate
	 * @param status
	 */
	public Project(int userId,String projectName, String description, LocalDate startDate, ProjectStatus status) {
		super();
		this.userId=userId;
		this.projectName = projectName;
		this.description = description;
		this.startDate = startDate;
		this.status = status;
	}
	/**
	 * @param projectId
	 * @param projectName
	 * @param description
	 * @param startDate
	 * @param status
	 */
	/**
	 * 
	 */
	public Project() {
		super();
	}
	/**
	 * @param userId
	 * @param projectId
	 * @param projectName
	 * @param description
	 * @param startDate
	 * @param status
	 */
	public Project(int userId, int projectId, String projectName, String description, LocalDate startDate,
			ProjectStatus status) {
		super();
		this.userId = userId;
		this.projectId = projectId;
		this.projectName = projectName;
		this.description = description;
		this.startDate = startDate;
		this.status = status;
	}
	/**
	 * @return the userId
	 */
	public int getUserId() {
		return userId;
	}
	/**
	 * @param userId the userId to set
	 */
	public void setUserId(int userId) {
		this.userId = userId;
	}
	@Override
	public String toString() {
		return "Project [ projectId=" + projectId + ", projectName=" + projectName
				+ ", description=" + description + ", startDate=" + startDate + ", status=" + status + "]";
	}

}
