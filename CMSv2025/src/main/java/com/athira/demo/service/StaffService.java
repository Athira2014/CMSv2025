package com.athira.demo.service;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.ExecutorService;

import javax.transaction.Transactional;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.athira.demo.dao.IPermissionDao;
import com.athira.demo.dao.IQualificationDao;
import com.athira.demo.dao.IRoleDao;
import com.athira.demo.dao.IRolesAndPermissionsDao;
import com.athira.demo.dao.IStaffActionLogDao;
import com.athira.demo.dao.IStaffDao;
import com.athira.demo.dao.IStaffQualificationDao;
import com.athira.demo.entity.Permission;
import com.athira.demo.entity.Qualification;
import com.athira.demo.entity.Role;
import com.athira.demo.entity.RolesAndPermissions;
import com.athira.demo.entity.Staff;
import com.athira.demo.entity.StaffActionLog;
import com.athira.demo.entity.StaffQualification;

@Transactional
@Service
public class StaffService implements IStaffService {

	@Autowired
	IStaffDao staffDao;

	@Autowired
	IStaffQualificationDao staffQualificationDao;

	@Autowired
	IStaffActionLogDao staffActionLogDao;

	@Autowired
	IQualificationDao qualificationDao;

	@Autowired
	ExecutorService executorService;
	
	@Autowired
	IAdminService adminService;

	@Transactional
	public List<StaffQualification> getAllStaffQualifications() {
		return staffQualificationDao.findAll();
	}

	@Transactional
	public List<StaffActionLog> getAllStaffActionLogs() {
		return staffActionLogDao.findAll();
	}

	public List<Qualification> getAllQualifications() {
		return qualificationDao.findAll();
	}

	public List<Staff> getAllStaff(Integer userId) {

		Role role = getUserRoleByUserId(userId);

		// Check if the user has the permission to view staff
		boolean hasPermission = checkIfUserHasPermission(role.getRoleId(), "VIEW_STAFF");

		// If no permission found, throw an exception
		if (!hasPermission) {
			throw new IllegalArgumentException("User does not have the permission to view staff.");
		}

		// If permission is found, return the list of staff
		return staffDao.spListingStaff(role.getRoleId(), "VIEW_STAFF");
	}

	public boolean checkIfUserHasPermission(Integer roleId, String permission) {

		boolean hasPermission = false;

		List<RolesAndPermissions> rolesAndPermissions = adminService.getRolesAndPermissionsByRoleId(roleId);

		for (RolesAndPermissions rolePerm : rolesAndPermissions) {
			if (permission.equals(rolePerm.getPermission())) {
				hasPermission = true;
				break;
			}
		}
		return hasPermission;
	}

	public Staff addStaff(Staff staff, Integer userId) {

		Role role = getUserRoleByUserId(userId);
		String permission = "ADD_STAFF";
		boolean hasPermission = checkIfUserHasPermission(role.getRoleId(), permission);

		// If no permission found, throw an exception
		if (!hasPermission) {
			throw new IllegalArgumentException("User does not have the permission to add new staff.");
		}

		return staffDao.spAddNewStaff(staff.getFirstName(), staff.getLastName(), staff.getDob(), staff.getRoleId(),
				staff.getPhone(), staff.getEmail(), staff.getJoiningDate(), staff.getTillDate(), staff.getSalary(),
				staff.getStatus(), staff.getAddress(), role.getRoleId(), permission);
	}

	public Role getUserRoleByUserId(Integer userId) {
		if (userId != null) {
			Optional<Staff> userOptional = staffDao.findById(userId);

			// If the staff doesn't exist, throw an exception
			if (!userOptional.isPresent()) {
				throw new IllegalArgumentException("User not found.");
			}

			Staff user = userOptional.get();
			return user.getRole();
		} else {
			throw new IllegalArgumentException("User id should not be null");
		}

	}

	/*
	 * user_Role INT, permission_Req VARCHAR(50), StaffId INT, St_FName VARCHAR(20),
	 * St_LName VARCHAR(20), sp_dob DATE, RoleId INT, sp_phone VARCHAR(10), sp_email
	 * VARCHAR(50), JoiningDate DATE, TillDate DATE, sp_salary DECIMAL(10,2),
	 * sp_status VARCHAR(15), sp_address VARCHAR(50))
	 */
	public Staff updateStaff(Staff staff, Integer userId) {

		Role role = getUserRoleByUserId(userId);
		String permission = "UPDATE_STAFF";
		boolean hasPermission = checkIfUserHasPermission(role.getRoleId(), permission);

		// If no permission found, throw an exception
		if (!hasPermission) {
			throw new IllegalArgumentException("User does not have the permission to modify staff.");
		}
		return staffDao.spUpdateStaff(role.getRoleId(), permission, staff.getStaffId(), staff.getFirstName(),
				staff.getLastName(), staff.getDob(), staff.getRoleId(), staff.getPhone(), staff.getEmail(),
				staff.getJoiningDate(), staff.getTillDate(), staff.getSalary(), staff.getStatus(), staff.getAddress());

	}

	public void disableStaff(Staff staff, Integer userId) {

		Role role = getUserRoleByUserId(userId);
		boolean hasPermission = checkIfUserHasPermission(role.getRoleId(), "DISABLE_STAFF");

		// If no permission found, throw an exception
		if (!hasPermission) {
			throw new IllegalArgumentException("User does not have the permission to modify staff.");
		}

		staffDao.disableStaff(staff.getStaffId());
	}

	public Staff getStaffByStaffId(Integer userId, Integer staffid) {

		Role role = getUserRoleByUserId(userId);
		boolean hasPermission = checkIfUserHasPermission(role.getRoleId(), "VIEW_STAFF");

		// If no permission found, throw an exception
		if (!hasPermission) {
			throw new IllegalArgumentException("User does not have the permission to view staff.");
		}

		return staffDao.spGetStaffById(staffid);
	}
}
