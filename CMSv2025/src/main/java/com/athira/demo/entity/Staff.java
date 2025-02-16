package com.athira.demo.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Type;
import org.joda.time.DateTime;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "staff")
public class Staff {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    @Column(name = "StaffId")
    private Integer staffId;

    @Column(name = "StFName", nullable = false, length = 20) 
    private String firstName;

    @Column(name = "StLName", nullable = false, length = 20) 
    private String lastName;

    @Column(name = "DOB", nullable = false)
    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    private DateTime dob;

    @ManyToOne
    @JoinColumn(name = "RoleId", insertable = false, updatable = false)  
    private Role role;
    
    @Column(name = "RoleId",  nullable = false)// Foreign key to Role table
    private Integer roleId;

    @Column(name = "Phone", length = 10)  
    private String phone;

    @Column(name = "Email", length = 50) 
    private String email;

    @Column(name = "JoiningDate", nullable = false)
    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    private DateTime joiningDate;

    @Column(name = "TillDate")
    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    private DateTime tillDate;

    @Column(name = "Salary", precision = 10, scale = 2)  
    private double salary;

    @Column(name = "Status", length = 15) 
    private String status;

    @Column(name = "Address", length = 50)  
    private String address;
    
    @JsonIgnore
    @OneToOne(mappedBy = "staff")
    private Doctor doctor;
    
    @JsonIgnore
    @OneToMany(mappedBy = "staff")
    private List<StaffAttendance> staffAttendances;
  
    /*
    @JsonIgnore
    @OneToMany(mappedBy = "staff")
    private List<StaffLogin> staffLogins;
    */
    
    @JsonIgnore
    @OneToMany(mappedBy = "staff")
    private List<StaffQualification> staffQualifications;
    
    @JsonIgnore
    @OneToMany(mappedBy = "staff")
    private List<StaffActionLog> staffActionLog;
    
    @JsonIgnore
    @OneToMany(mappedBy = "staff")
    private List<User> users;
    
    // Default constructor
    public Staff() {}

	public Staff(Integer staffId, String firstName, String lastName, DateTime dob, Integer roleId, String phone, String email,
			DateTime joiningDate, DateTime tillDate, double salary, String status, String address) {
		super();
		this.staffId = staffId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dob = dob;
		this.roleId = roleId;
		this.phone = phone;
		this.email = email;
		this.joiningDate = joiningDate;
		this.tillDate = tillDate;
		this.salary = salary;
		this.status = status;
		this.address = address;
	}

	public Integer getStaffId() {
		return staffId;
	}
	public void setStaffId(Integer staffId) {
		this.staffId = staffId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public DateTime getDob() {
		return dob;
	}
	public void setDob(DateTime dob) {
		this.dob = dob;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public DateTime getJoiningDate() {
		return joiningDate;
	}
	public void setJoiningDate(DateTime joiningDate) {
		this.joiningDate = joiningDate;
	}
	public DateTime getTillDate() {
		return tillDate;
	}
	public void setTillDate(DateTime tillDate) {
		this.tillDate = tillDate;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	public List<StaffAttendance> getStaffAttendances() {
		return staffAttendances;
	}

	public void setStaffAttendances(List<StaffAttendance> staffAttendances) {
		this.staffAttendances = staffAttendances;
	}

	/*
	 * public List<StaffLogin> getStaffLogins() { return staffLogins; }
	 * 
	 * public void setStaffLogins(List<StaffLogin> staffLogins) { this.staffLogins =
	 * staffLogins; }
	 */
	public List<StaffQualification> getStaffQualifications() {
		return staffQualifications;
	}

	public void setStaffQualifications(List<StaffQualification> staffQualifications) {
		this.staffQualifications = staffQualifications;
	}

	public List<StaffActionLog> getStaffActionLog() {
		return staffActionLog;
	}

	public void setStaffActionLog(List<StaffActionLog> staffActionLog) {
		this.staffActionLog = staffActionLog;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

}
