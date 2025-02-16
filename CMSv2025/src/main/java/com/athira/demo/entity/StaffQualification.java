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
@Table(name = "staffqualification")
public class StaffQualification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-increment primary key
    @Column(name = "SqId")
    private Integer sqId;

    @ManyToOne
    @JoinColumn(name = "StaffId", insertable = false, updatable = false)
    private Staff staff;
    
    @Column(name = "StaffId", nullable = false)
    private Integer staffId;

    @ManyToOne
    @JoinColumn(name = "QId", insertable = false, updatable = false)
    private Qualification qualification;
    
    @Column(name = "QId", nullable = false)
    private Integer qId;

    @Column(name = "CreatedDate")
    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    private DateTime createdDate;
    
    // Default constructor
    public StaffQualification() {}

	public StaffQualification(Integer sqId, Integer staffId, Integer qId, DateTime createdDate) {
		super();
		this.sqId = sqId;
		this.staffId = staffId;
		this.qId = qId;
		this.createdDate = createdDate;
	}

	public Integer getSqId() {
		return sqId;
	}

	public void setSqId(Integer sqId) {
		this.sqId = sqId;
	}

	public Staff getStaff() {
		return staff;
	}

	public void setStaff(Staff staff) {
		this.staff = staff;
	}

	public Qualification getQualification() {
		return qualification;
	}

	public void setQualification(Qualification qualification) {
		this.qualification = qualification;
	}

	public DateTime getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(DateTime createdDate) {
		this.createdDate = createdDate;
	}

	public Integer getStaffId() {
		return staffId;
	}

	public void setStaffId(Integer staffId) {
		this.staffId = staffId;
	}

	public Integer getqId() {
		return qId;
	}

	public void setqId(Integer qId) {
		this.qId = qId;
	}
}
