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
@Table(name = "staffattendance")
public class StaffAttendance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-increment primary key
    @Column(name = "StAttedanceId")
    private Integer stAttedanceId;

    @ManyToOne
    @JoinColumn(name = "StaffId", insertable = false, updatable = false)
    private Staff staff; // The ID of the staff member
    
    @Column(name = "StaffId", nullable = false)
    private Integer staffId;

    @Column(name = "EntryDateTime")
    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    private DateTime entryDateTime; // The entry date and time when the staff member checked in

    @Column(name = "ExitDateTime")
    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    private DateTime exitDateTime; // The exit date and time when the staff member checked out

    @Column(name = "LeaveStatus")
    private char leaveStatus;
  
    // Default constructor
    public StaffAttendance() {}

	public StaffAttendance(Integer stAttedanceId, Integer staffId, DateTime entryDateTime, DateTime exitDateTime,
			char leaveStatus) {
		super();
		this.stAttedanceId = stAttedanceId;
		this.staffId = staffId;
		this.entryDateTime = entryDateTime;
		this.exitDateTime = exitDateTime;
		this.leaveStatus = leaveStatus;
	}

	public Integer getStAttedanceId() {
		return stAttedanceId;
	}

	public void setStAttedanceId(Integer stAttedanceId) {
		this.stAttedanceId = stAttedanceId;
	}

	public Staff getStaff() {
		return staff;
	}

	public void setStaff(Staff staff) {
		this.staff = staff;
	}

	public DateTime getEntryDateTime() {
		return entryDateTime;
	}

	public void setEntryDateTime(DateTime entryDateTime) {
		this.entryDateTime = entryDateTime;
	}

	public DateTime getExitDateTime() {
		return exitDateTime;
	}

	public void setExitDateTime(DateTime exitDateTime) {
		this.exitDateTime = exitDateTime;
	}

	public char getLeaveStatus() {
		return leaveStatus;
	}

	public void setLeaveStatus(char leaveStatus) {
		this.leaveStatus = leaveStatus;
	}

	public Integer getStaffId() {
		return staffId;
	}

	public void setStaffId(Integer staffId) {
		this.staffId = staffId;
	}

}