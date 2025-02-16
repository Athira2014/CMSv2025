package com.athira.demo.service;

import java.util.List;

import com.athira.demo.entity.Permission;
import com.athira.demo.entity.Qualification;
import com.athira.demo.entity.Role;
import com.athira.demo.entity.RolesAndPermissions;
import com.athira.demo.entity.Staff;
import com.athira.demo.entity.StaffActionLog;
import com.athira.demo.entity.StaffQualification;

public interface IStaffService {

	List<StaffQualification> getAllStaffQualifications();

	List<StaffActionLog> getAllStaffActionLogs();

	List<Qualification> getAllQualifications();

	List<Staff> getAllStaff(Integer staffId);

	Staff addStaff(Staff staff, Integer userId);

	Staff updateStaff(Staff staff, Integer userId);

	void disableStaff(Staff staff, Integer userId);

	Staff getStaffByStaffId(Integer userid, Integer staffid);

}
