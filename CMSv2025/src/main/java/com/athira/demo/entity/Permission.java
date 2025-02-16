package com.athira.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Type;
import org.joda.time.DateTime;

@Entity
@Table(name = "permission")
public class Permission {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PermissionId")
    private Integer permissionId;

    @Column(name = "Permission", nullable = false, length = 50)
    private String permission;

    @Column(name = "isActive", nullable = false)
    private boolean isActive;

    @Column(name = "CreatedDate", nullable = false)
    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    private DateTime createdDate;

    // Default constructor
    public Permission() {
    }

    // Parameterized constructor

	public Permission(Integer permissionId, String permission, boolean isActive, DateTime createdDate) {
		super();
		this.permissionId = permissionId;
		this.permission = permission;
		this.isActive = isActive;
		this.createdDate = createdDate;
	}

	public Integer getPermissionId() {
		return permissionId;
	}

	public void setPermissionId(Integer permissionId) {
		this.permissionId = permissionId;
	}

	public String getPermission() {
		return permission;
	}

	public void setPermission(String permission) {
		if(permission == null || permission.isEmpty()) {
    		throw new IllegalArgumentException("Permission should not be empty.");
    	}
		this.permission = permission;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public DateTime getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(DateTime createdDate) {
		this.createdDate = createdDate;
	}

}
