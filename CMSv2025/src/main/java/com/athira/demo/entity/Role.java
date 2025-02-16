package com.athira.demo.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Type;
import org.joda.time.DateTime;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "role")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    @Column(name = "RoleId")
    private Integer roleId;

    @Column(name = "Role", nullable = false, length = 20)
    private String role;

    @Column(name = "Responsibility", nullable = true, length = 100)
    private String responsibility;

    @Column(name = "isActive", nullable = false)
    private boolean isActive;

    @Column(name = "CreatedDate", nullable = false)
    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    private DateTime createdDate;
    
    @JsonIgnore
    @OneToMany(mappedBy = "role",  cascade = CascadeType.ALL)
    private List<Staff> staffList;
    
    @JsonIgnore
    @OneToMany(mappedBy = "role")
    private List<RolesAndPermissions> rolesAndPermissions;
    
    @JsonIgnore
    @OneToMany(mappedBy = "role")
    private List<User> users;

    public Role() {
    }

    public Role(Integer roleId, String responsibility, boolean isActive, DateTime createdDate, List<Staff> staffList) {
		super();
		this.roleId = roleId;
		this.responsibility = responsibility;
		this.isActive = isActive;
		this.createdDate = createdDate;
		this.staffList = staffList;
	}

	public List<Staff> getStaffList() {
		return staffList;
	}


	public void setStaffList(List<Staff> staffList) {
		this.staffList = staffList;
	}


	public List<RolesAndPermissions> getRolesAndPermissions() {
		return rolesAndPermissions;
	}


	public void setRolesAndPermissions(List<RolesAndPermissions> rolesAndPermissions) {
		this.rolesAndPermissions = rolesAndPermissions;
	}


	public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
    	if(role == null || role.isEmpty()) {
    		throw new IllegalArgumentException("Role should not be empty.");
    	}
        this.roleId = roleId;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getResponsibility() {
        return responsibility;
    }

    public void setResponsibility(String responsibility) {
    	if(responsibility == null || responsibility.isEmpty()) {
    		throw new IllegalArgumentException("Responsibility should not be empty.");
    	}
        this.responsibility = responsibility;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        this.isActive = active;
    }

    public DateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(DateTime createdDate) {
        this.createdDate = createdDate;
    }
}

