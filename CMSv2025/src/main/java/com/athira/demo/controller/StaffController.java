package com.athira.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.athira.demo.common.APIResponse;
import com.athira.demo.entity.Qualification;
import com.athira.demo.entity.Staff;
import com.athira.demo.entity.StaffQualification;
import com.athira.demo.entity.User;
import com.athira.demo.service.ILoginService;
import com.athira.demo.service.IStaffService;

@RestController
@RequestMapping("api/")
public class StaffController {

	@Autowired
	IStaffService staffService;

	/*
	 * @Autowired IStaffLoginService staffloginService;
	 */

	@Autowired
	ILoginService loginService;
	
	// List all staffs
	@GetMapping("staffs/{userid}")
	public List<Staff> getAllStaff(@PathVariable Integer userid) {
		return staffService.getAllStaff(userid);
	}

	// List all staffs
	@GetMapping("staffs/{userid}/{staffid}")
	public Staff getStaffByStaffId(@PathVariable Integer userid, @PathVariable Integer staffid) {
		// user id is to verify the permission to view
		return staffService.getStaffByStaffId(userid, staffid);
	}

	// Get attendance of all staff
//	@GetMapping("attendances")
//	public List<StaffLogin> getAllAttendance() {
//		return staffloginService.getAllAttendance();
//	}
	
	@GetMapping("attendances")
	public List<Staff> getAllAttendance() {
		return loginService.getAllAttendance();
	}

	// List Staff Qualification
	@GetMapping("staffQualifications")
	public List<StaffQualification> getAllStaffQualifications() {
		return staffService.getAllStaffQualifications();
	}

	// List Qualification
	@GetMapping("qualifications")
	public List<Qualification> getAllQualifications() {
		return staffService.getAllQualifications();
	}

	// Add new staff
	@PostMapping("staffs/{userId}")
	public ResponseEntity<APIResponse> addStaff(@RequestBody Staff staff, @PathVariable Integer userId) {

		APIResponse apiResponse = new APIResponse();

		try {
			Staff staffEntity = staffService.addStaff(staff, userId);
			apiResponse.setStatus(200);
			apiResponse.setData(staffEntity);

		} catch (Exception e) {
			apiResponse.setStatus(500);
			apiResponse.setError(e.getMessage());
		}

		return ResponseEntity.status(apiResponse.getStatus()).body(apiResponse);
	}

	// Update staff
	@PutMapping("staffs/{userId}")
	public ResponseEntity<APIResponse> updateStaff(@RequestBody Staff staff, @PathVariable Integer userId) {

		APIResponse apiResponse = new APIResponse();

		try {
			Staff staffEntity = staffService.updateStaff(staff, userId);
			apiResponse.setStatus(200);
			apiResponse.setData(staffEntity);

		} catch (Exception e) {
			apiResponse.setStatus(500);
			apiResponse.setError(e.getMessage());
		}

		return ResponseEntity.status(apiResponse.getStatus()).body(apiResponse);
	}

	// Disable staff
	@DeleteMapping("staffs/{userId}")
	public ResponseEntity<APIResponse> disableStaff(@RequestBody Staff staff, @PathVariable Integer userId) {

		APIResponse apiResponse = new APIResponse();

		try {
			staffService.disableStaff(staff, userId);
			apiResponse.setStatus(200);
			apiResponse.setData("Staff status disabled succesfully!");

		} catch (Exception e) {
			apiResponse.setStatus(500);
			apiResponse.setError(e.getMessage());
		}

		return ResponseEntity.status(apiResponse.getStatus()).body(apiResponse);
	}

}
