/**
 * 
 */
package com.bts.beans;

import java.time.LocalDate;

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
}
