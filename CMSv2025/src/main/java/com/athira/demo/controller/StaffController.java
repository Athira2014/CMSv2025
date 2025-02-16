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
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.athira.demo.common.APIResponse;
import com.athira.demo.entity.Appointment;
import com.athira.demo.entity.Qualification;
import com.athira.demo.entity.Staff;
import com.athira.demo.entity.StaffQualification;
import com.athira.demo.entity.User;
import com.athira.demo.service.ILoginService;
import com.athira.demo.service.IStaffService;
import com.athira.demo.util.JwtUtils;

@RestController
@RequestMapping("api/")
public class StaffController {

	@Autowired
	IStaffService staffService;

	@Autowired
	JwtUtils jwtUtils;

	/*
	 * @Autowired IStaffLoginService staffloginService;
	 */

	@Autowired
	ILoginService loginService;

	// List all staffs
	@GetMapping("staffs/{userid}")
	public ResponseEntity<APIResponse> getAllStaff(@PathVariable Integer userid,
			@RequestHeader(value = "authorization", defaultValue = "") String auth) {

		APIResponse apiResponse = new APIResponse();

		// Authorizing JWT
		ResponseEntity<APIResponse> tokenResponse = jwtUtils.verifyToken(auth);

		if (tokenResponse == null) {
			return tokenResponse;
		}

		try {
			List<Staff> staffs = staffService.getAllStaff(userid);
			apiResponse.setStatus(200);
			apiResponse.setData(staffs);

		} catch (Exception e) {
			apiResponse.setStatus(500);
			apiResponse.setError(e.getMessage());
		}

		return ResponseEntity.status(apiResponse.getStatus()).body(apiResponse);

	}

	// List all staffs
	@GetMapping("staffs/{userid}/{staffid}")
	public ResponseEntity<APIResponse> getStaffByStaffId(@PathVariable Integer userid, @PathVariable Integer staffid,
			@RequestHeader(value = "authorization", defaultValue = "") String auth) {

		APIResponse apiResponse = new APIResponse();

		// Authorizing JWT
		ResponseEntity<APIResponse> tokenResponse = jwtUtils.verifyToken(auth);

		if (tokenResponse == null) {
			return tokenResponse;
		}

		try {
			// user id is to verify the permission to view
			Staff staff = staffService.getStaffByStaffId(userid, staffid);
			apiResponse.setStatus(200);
			apiResponse.setData(staff);

		} catch (Exception e) {
			apiResponse.setStatus(500);
			apiResponse.setError(e.getMessage());
		}

		return ResponseEntity.status(apiResponse.getStatus()).body(apiResponse);

	}

	// Get attendance of all staff
//	@GetMapping("attendances")
//	public List<StaffLogin> getAllAttendance() {
//		return staffloginService.getAllAttendance();
//	}

	@GetMapping("attendances")
	public ResponseEntity<APIResponse> getAllAttendance(
			@RequestHeader(value = "authorization", defaultValue = "") String auth) {

		APIResponse apiResponse = new APIResponse();

		// Authorizing JWT
		ResponseEntity<APIResponse> tokenResponse = jwtUtils.verifyToken(auth);

		if (tokenResponse == null) {
			return tokenResponse;
		}

		try {
			List<Staff> staffAttendences = loginService.getAllAttendance();
			apiResponse.setStatus(200);
			apiResponse.setData(staffAttendences);

		} catch (Exception e) {
			apiResponse.setStatus(500);
			apiResponse.setError(e.getMessage());
		}

		return ResponseEntity.status(apiResponse.getStatus()).body(apiResponse);
	}

	// List Staff Qualification
	@GetMapping("staffQualifications")
	public ResponseEntity<APIResponse> getAllStaffQualifications(
			@RequestHeader(value = "authorization", defaultValue = "") String auth) {

		APIResponse apiResponse = new APIResponse();

		// Authorizing JWT
		ResponseEntity<APIResponse> tokenResponse = jwtUtils.verifyToken(auth);

		if (tokenResponse == null) {
			return tokenResponse;
		}

		try {
			List<StaffQualification> staffQualifications = staffService.getAllStaffQualifications();
			apiResponse.setStatus(200);
			apiResponse.setData(staffQualifications);

		} catch (Exception e) {
			apiResponse.setStatus(500);
			apiResponse.setError(e.getMessage());
		}

		return ResponseEntity.status(apiResponse.getStatus()).body(apiResponse);

	}

	// List Qualification
	@GetMapping("qualifications")
	public List<Qualification> getAllQualifications() {
		return staffService.getAllQualifications();
	}

	// Add new staff
	@PostMapping("staffs/{userId}")
	public ResponseEntity<APIResponse> addStaff(@RequestBody Staff staff, @PathVariable Integer userId,
			@RequestHeader(value = "authorization", defaultValue = "") String auth) {

		APIResponse apiResponse = new APIResponse();

		// Authorizing JWT
		ResponseEntity<APIResponse> tokenResponse = jwtUtils.verifyToken(auth);

		if (tokenResponse == null) {
			return tokenResponse;
		}

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
	public ResponseEntity<APIResponse> updateStaff(@RequestBody Staff staff, @PathVariable Integer userId,
			@RequestHeader(value = "authorization", defaultValue = "") String auth) {

		APIResponse apiResponse = new APIResponse();

		// Authorizing JWT
		ResponseEntity<APIResponse> tokenResponse = jwtUtils.verifyToken(auth);

		if (tokenResponse == null) {
			return tokenResponse;
		}

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
	public ResponseEntity<APIResponse> disableStaff(@RequestBody Staff staff, @PathVariable Integer userId,
			@RequestHeader(value = "authorization", defaultValue = "") String auth) {

		APIResponse apiResponse = new APIResponse();

		// Authorizing JWT
		ResponseEntity<APIResponse> tokenResponse = jwtUtils.verifyToken(auth);

		if (tokenResponse == null) {
			return tokenResponse;
		}

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
