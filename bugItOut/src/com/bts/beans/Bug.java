/**
 * 
 */
package com.bts.beans;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.bts.beans.enums.BugStatus;
import com.bts.beans.enums.Severity;

/**
 * 
 */
public class Bug {
	private int bugId;
	private String title;
	private String description;
	private int projectId;
	private int createdBy;
	private LocalDateTime openDate;
	private int assignedTo;
	private boolean markedForClosing;
	private int closedBy;
	private LocalDate closedOn;
	private BugStatus status;
	private Severity severity;
	public int getBugId() {
		return bugId;
	}
	public void setBugId(int bugId) {
		this.bugId = bugId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getProjectId() {
		return projectId;
	}
	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}
	public int getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(int createdBy) {
		this.createdBy = createdBy;
	}
	public LocalDateTime getOpenDate() {
		return openDate;
	}
	public void setOpenDate(LocalDateTime localDateTime) {
		this.openDate = localDateTime;
	}
	public int getAssignedTo() {
		return assignedTo;
	}
	public void setAssignedTo(int assignedTo) {
		this.assignedTo = assignedTo;
	}
	public boolean isMarkedForClosing() {
		return markedForClosing;
	}
	public void setMarkedForClosing(boolean markedForClosing) {
		this.markedForClosing = markedForClosing;
	}
	public int getClosedBy() {
		return closedBy;
	}
	public void setClosedBy(int closedBy) {
		this.closedBy = closedBy;
	}
	public Bug() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Bug(int bugId, String title, String description, int projectId, int createdBy, LocalDateTime openDate,
			int assignedTo, boolean markedForClosing, int closedBy, LocalDate closedOn, BugStatus status,
			Severity severity) {
		super();
		this.bugId = bugId;
		this.title = title;
		this.description = description;
		this.projectId = projectId;
		this.createdBy = createdBy;
		this.openDate = openDate;
		this.assignedTo = assignedTo;
		this.markedForClosing = markedForClosing;
		this.closedBy = closedBy;
		this.closedOn = closedOn;
		this.status = status;
		this.severity = severity;
	}
	/**
	 * @param bugId
	 * @param title
	 * @param description
	 * @param openDate2
	 * @param status
	 */
	public Bug(int bugId, String title, String description, LocalDateTime openDate2, BugStatus status) {
		super();
		this.bugId = bugId;
		this.title = title;
		this.description = description;
		this.openDate = openDate2;
		this.status = status;
	}
	@Override
	public String toString() {
		return "Bug [bugId=" + bugId + ", title=" + title + ", description=" + description + ", projectId=" + projectId
				+ ", createdBy=" + createdBy + ", openDate=" + openDate + ", assignedTo=" + assignedTo
				+ ", markedForClosing=" + markedForClosing + ", closedBy=" + closedBy + ", closedOn=" + closedOn
				+ ", status=" + status + ", severity=" + severity + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + bugId;
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
		Bug other = (Bug) obj;
		if (bugId != other.bugId)
			return false;
		return true;
	}
	public LocalDate getClosedOn() {
		return closedOn;
	}
	public void setClosedOn(LocalDate closedOn) {
		this.closedOn = closedOn;
	}
	public BugStatus getStatus() {
		return status;
	}
	public void setStatus(BugStatus status) {
		this.status = status;
	}
	public Severity getSeverity() {
		return severity;
	}
	public void setSeverity(Severity severity) {
		this.severity = severity;
	}
	
}
