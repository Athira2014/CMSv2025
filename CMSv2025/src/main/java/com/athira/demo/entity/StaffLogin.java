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


// 	// Not using stafflogin anymore instead user User


@Entity
@Table(name = "stafflogin")
public class StaffLogin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-increment primary key
    @Column(name = "StLoginId")
    private Integer stLoginId;

    @ManyToOne
    @JoinColumn(name = "StaffId", insertable = false, updatable = false)
    private Staff staff;

    @Column(name = "StaffId")
    private Integer staffId;
    
    @Column(name = "UserName")
    private String userName; // The username used by the staff member

    @Column(name = "Password")
    private String password; // The password used by the staff member

    @Column(name = "CreatedDate")
    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    private DateTime createdDate; 

    public StaffLogin() {}

	public StaffLogin(Integer stLoginId, Integer staffId, String userName, String password, DateTime createdDate) {
		super();
		this.stLoginId = stLoginId;
		this.staffId = staffId;
		this.userName = userName;
		this.password = password;
		this.createdDate = createdDate;
	}

	public Integer getStLoginId() {
		return stLoginId;
	}

	public void setStLoginId(Integer stLoginId) {
		this.stLoginId = stLoginId;
	}

	public Staff getStaff() {
		return staff;
	}

	public void setStaff(Staff staff) {
		this.staff = staff;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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
    
}
