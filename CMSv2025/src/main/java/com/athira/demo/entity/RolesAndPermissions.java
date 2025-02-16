package com.athira.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.hibernate.annotations.Type;
import org.joda.time.DateTime;

@Entity
@Table(name = "rolesandpermissions")
public class RolesAndPermissions {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-increment primary key
    @Column(name = "RoleAndPermId")
    private Integer roleAndPermId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "RoleId", insertable = false, updatable = false) 
    private Role role; // Reference to the Role entity

    @Column(name = "RoleId")// Foreign key to Role
    private Integer roleId;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "PermissionId", insertable = false, updatable = false) 
    private Permission permission; // Reference to the Permission entity
    
    @Column(name = "PermissionId")// Foreign key to Permission
    private Integer permissionId;

    @Column(name = "CreatedDate")
    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    private DateTime createdDate; // The date when the record was created

    @Column(name = "IsActive")
    private boolean isActive;

    // Default constructor
    public RolesAndPermissions() {}

	public RolesAndPermissions(Integer roleAndPermId, Integer roleId, Integer permissionId, DateTime createdDate,
			boolean isActive) {
		super();
		this.roleAndPermId = roleAndPermId;
		this.roleId = roleId;
		this.permissionId = permissionId;
		this.createdDate = createdDate;
		this.isActive = isActive;
	}

	public int getRoleAndPermId() {
		return roleAndPermId;
	}

	public void setRoleAndPermId(int roleAndPermId) {
		this.roleAndPermId = roleAndPermId;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public Permission getPermission() {
		return permission;
	}

	public void setPermission(Permission permission) {
		this.permission = permission;
	}

	public DateTime getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(DateTime createdDate) {
		this.createdDate = createdDate;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public int getPermissionId() {
		return permissionId;
	}

	public void setPermissionId(int permissionId) {
		this.permissionId = permissionId;
	}

}

