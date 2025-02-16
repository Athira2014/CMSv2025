package com.athira.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.hibernate.annotations.Type;
import org.joda.time.DateTime;

@Entity
@Table(name = "staffactionlog")
public class StaffActionLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-increment primary key
    @Column(name = "LogId")
    private Integer logId;

    @ManyToOne
    @JoinColumn(name = "StaffId", insertable = false, updatable = false)
    private Staff staff; 
    
    @Column(name = "StaffId", nullable = false)
    private Integer staffId;

    @Column(name = "ToTable")
    private String toTable; // The table that the action is performed on

    @Column(name = "Action")
    private String action; // Description of the action performed (e.g., "INSERT", "UPDATE", etc.)

    @Column(name = "ActionDate")
    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    private DateTime actionDate;

    public StaffActionLog() {}

	public StaffActionLog(Integer logId, Integer staffId, String toTable, String action, DateTime actionDate) {
		super();
		this.logId = logId;
		this.staffId = staffId;
		this.toTable = toTable;
		this.action = action;
		this.actionDate = actionDate;
	}

	public Integer getLogId() {
		return logId;
	}

	public void setLogId(Integer logId) {
		this.logId = logId;
	}

	public Staff getStaff() {
		return staff;
	}

	public void setStaff(Staff staff) {
		this.staff = staff;
	}

	public String getToTable() {
		return toTable;
	}

	public void setToTable(String toTable) {
		this.toTable = toTable;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public DateTime getActionDate() {
		return actionDate;
	}

	public void setActionDate(DateTime actionDate) {
		this.actionDate = actionDate;
	}

	public Integer getStaffId() {
		return staffId;
	}

	public void setStaffId(Integer staffId) {
		this.staffId = staffId;
	}

}

