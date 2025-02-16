package com.athira.demo.entity;

import javax.persistence.*;

import org.hibernate.annotations.Type;
import org.joda.time.DateTime;

import java.util.Date;

@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Integer userId;  

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "StaffId", insertable = false, updatable = false)
    private Staff staff;  // Maps to the `staff_id` foreign key
    
    @Column(name = "StaffId")
    private Integer staffId;

    @Column(name = "username", nullable = false, unique = true)
    private String userName; 
    
    @Column(name = "email", nullable = false, unique = true)
    private String email; 

    @Column(name = "password_hash", nullable = false)
    private String passwordHash;  

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "RoleId", insertable = false, updatable = false) 
    private Role role; // Reference to the Role entity

    @Column(name = "RoleId")// Foreign key to Role
    private Integer roleId;

    @Column(name = "last_login")
    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    private DateTime lastLogin;  // Maps to `last_login`

    @Column(name = "is_active", nullable = false)
    private boolean isActive = true;  // Maps to `is_active
    
	@Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    private DateTime createdAt;
    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    private DateTime updatedAt;

    // Constructors
    public User() {}


	public User(Integer userId, Integer staffId, String userName, String email, String passwordHash, Integer roleId,
			DateTime lastLogin, boolean isActive, DateTime createdAt, DateTime updatedAt) {
		super();
		this.userId = userId;
		this.staffId = staffId;
		this.userName = userName;
		this.email = email;
		this.passwordHash = passwordHash;
		this.roleId = roleId;
		this.lastLogin = lastLogin;
		this.isActive = isActive;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}


	// Getters and Setters
    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Staff getStaff() {
        return staff;
    }

    public void setStaff(Staff staff) {
        this.staff = staff;
    }

    public String getUsername() {
        return userName;
    }

    public void setUsername(String userName) {
        this.userName = userName;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public Integer getStaffId() {
		return staffId;
	}

	public void setStaffId(Integer staffId) {
		this.staffId = staffId;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public DateTime getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(DateTime lastLogin) {
        this.lastLogin = lastLogin;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

	public DateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(DateTime createdAt) {
		this.createdAt = createdAt;
	}

	public DateTime getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(DateTime updatedAt) {
		this.updatedAt = updatedAt;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	@Override
	public String toString() {
		return "User [userId=" + userId + ", staffId=" + staffId + ", userName=" + userName + ", email=" + email
				+ ", passwordHash=" + passwordHash + ", roleId=" + roleId + ", lastLogin=" + lastLogin + ", isActive="
				+ isActive + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + "]";
	}

}
