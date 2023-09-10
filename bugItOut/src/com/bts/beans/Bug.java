/**
 * 
 */
package com.bts.beans;

import java.time.LocalDate;
import java.util.Objects;

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
	private LocalDate openDate;
	private int assignedTo;
	private boolean markedForClosing;
	private int closedBy;
	private LocalDate closedOn;
	private BugStatus status;
	private Severity severity;
	public Bug(String title, String description, int projectId, int createdBy, LocalDate openDate, BugStatus status,
			Severity severity) {
		super();
		this.title = title;
		this.description = description;
		this.projectId = projectId;
		this.createdBy = createdBy;
		this.openDate = openDate;
		this.status = status;
		this.severity = severity;
	}
	public Bug() {
		super();
	}
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
	public LocalDate getOpenDate() {
		return openDate;
	}
	public void setOpenDate(LocalDate openDate) {
		this.openDate = openDate;
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
	@Override
	public int hashCode() {
		return Objects.hash(bugId);
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
		return bugId == other.bugId;
	}
	@Override
	public String toString() {
		return "Bug [bugId=" + bugId + ", title=" + title + ", description=" + description + ", projectId=" + projectId
				+ ", createdBy=" + createdBy + ", openDate=" + openDate + ", assignedTo=" + assignedTo
				+ ", markedForClosing=" + markedForClosing + ", closedBy=" + closedBy + ", closedOn=" + closedOn
				+ ", status=" + status + ", severity=" + severity + "]";
	}
	
	
}
