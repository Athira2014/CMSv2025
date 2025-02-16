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
import com.athira.demo.entity.Permission;
import com.athira.demo.entity.Role;
import com.athira.demo.entity.RolesAndPermissions;
import com.athira.demo.entity.StaffActionLog;
import com.athira.demo.entity.User;
import com.athira.demo.service.IAdminService;
import com.athira.demo.service.IStaffService;
import com.athira.demo.service.IUserService;
import com.athira.demo.util.JwtUtils;

@RestController
@RequestMapping("api/")
public class AdminController {

	@Autowired
	IAdminService adminService;

	@Autowired
	IStaffService staffService;

	@Autowired
	IUserService userService;

	@Autowired
	JwtUtils jwtUtils;

	// List all roles
	@GetMapping("admin/roles")
	public ResponseEntity<APIResponse> getAllRoles(
			@RequestHeader(value = "authorization", defaultValue = "") String auth) throws Exception {

		APIResponse apiResponse = new APIResponse();
		try {
			// Verify the token
			jwtUtils.verify(auth);
		} catch (Exception e) {
			// Token verification failed (expired or invalid)

			apiResponse.setStatus(401); // Unauthorized
			apiResponse.setData("Invalid or expired token");
			return ResponseEntity.status(401).body(apiResponse);
		}

		// Token is valid, proceed to fetch all roles
		List<Role> roles = adminService.getAllRoles();
		apiResponse.setData(roles);
		apiResponse.setStatus(200);
		return ResponseEntity.status(200).body(apiResponse);
	}

	// List all roles and permissions
	@GetMapping("admin/rolesAndPermissions")
	public ResponseEntity<APIResponse> getAllRolesAndPermissions(
			@RequestHeader(value = "authorization", defaultValue = "") String auth) throws Exception {

		APIResponse apiResponse = new APIResponse();
		try {

			jwtUtils.verify(auth);
		} catch (Exception e) {

			apiResponse.setStatus(401); // Unauthorized
			apiResponse.setData("Invalid or expired token");
			return ResponseEntity.status(apiResponse.getStatus()).body(apiResponse);
		}

		// Token is valid, proceed to fetch all roles and permissions
		List<RolesAndPermissions> rolesAndPermission = adminService.getAllRolesAndPermissions();
		apiResponse.setData(rolesAndPermission);
		apiResponse.setStatus(200);
		return ResponseEntity.status(apiResponse.getStatus()).body(apiResponse);

	}

	// List all staff action log
	@GetMapping("staffActionLogs")
	public List<StaffActionLog> getAllStaffActionLogs() {
		return staffService.getAllStaffActionLogs();
	}

	// create roles
	@PostMapping("admin/roles")
	public ResponseEntity<APIResponse> createRoles(@RequestBody Role role,
			@RequestHeader(value = "authorization", defaultValue = "") String auth) throws Exception {

		APIResponse apiResponse = new APIResponse();
		try {

			jwtUtils.verify(auth);
		} catch (Exception e) {

			apiResponse.setStatus(401); // Unauthorized
			apiResponse.setData("Invalid or expired token");
			return ResponseEntity.status(apiResponse.getStatus()).body(apiResponse);
		}

		try {
			Role roleEntity = adminService.saveRoles(role);
			apiResponse.setStatus(200);
			apiResponse.setData(roleEntity);

		} catch (Exception e) {
			apiResponse.setStatus(500);
			apiResponse.setError(e.getMessage());
		}

		return ResponseEntity.status(apiResponse.getStatus()).body(apiResponse);
	}

	// update roles
	@PutMapping("admin/roles")
	public ResponseEntity<APIResponse> updateRoles(@RequestBody Role role,
			@RequestHeader(value = "authorization", defaultValue = "") String auth) throws Exception {

		APIResponse apiResponse = new APIResponse();
		try {

			jwtUtils.verify(auth);
		} catch (Exception e) {

			apiResponse.setStatus(401); // Unauthorized
			apiResponse.setData("Invalid or expired token");
			return ResponseEntity.status(apiResponse.getStatus()).body(apiResponse);
		}

		try {
			Role roleEntity = adminService.saveRoles(role);
			apiResponse.setStatus(200);
			apiResponse.setData(roleEntity);

		} catch (Exception e) {
			apiResponse.setStatus(500);
			apiResponse.setError(e.getMessage());
		}

		return ResponseEntity.status(apiResponse.getStatus()).body(apiResponse);
	}

	// Disable roles
	@DeleteMapping("admin/roles/{id}")
	public ResponseEntity<APIResponse> disableRole(
			@RequestHeader(value = "authorization", defaultValue = "") String auth, @PathVariable Integer id) {

		APIResponse apiResponse = new APIResponse();
		try {

			jwtUtils.verify(auth);
		} catch (Exception e) {

			apiResponse.setStatus(401); // Unauthorized
			apiResponse.setData("Invalid or expired token");
			return ResponseEntity.status(apiResponse.getStatus()).body(apiResponse);
		}

		try {
			adminService.disableRole(id);
			apiResponse.setStatus(200);
			apiResponse.setData("Role disabled successfully!");

		} catch (Exception e) {
			apiResponse.setStatus(500);
			apiResponse.setError(e.getMessage());
		}

		return ResponseEntity.status(apiResponse.getStatus()).body(apiResponse);
	}

	// List Permissions
	@GetMapping("admin/permissions")
	public ResponseEntity<APIResponse> getAllPermissions(
			@RequestHeader(value = "authorization", defaultValue = "") String auth) {

		APIResponse apiResponse = new APIResponse();
		try {
			jwtUtils.verify(auth);
		} catch (Exception e) {

			apiResponse.setStatus(401); // Unauthorized
			apiResponse.setData("Invalid or expired token");
			return ResponseEntity.status(apiResponse.getStatus()).body(apiResponse);
		}

		try {
			List<Permission> permissions = adminService.getAllPermissions();
			apiResponse.setStatus(200);
			apiResponse.setData(permissions);

		} catch (Exception e) {
			apiResponse.setStatus(500);
			apiResponse.setError(e.getMessage());
		}

		return ResponseEntity.status(apiResponse.getStatus()).body(apiResponse);
	}
	
	// create permission
	@PostMapping("admin/permissions")
	public ResponseEntity<APIResponse> createPermissions(@RequestBody Permission permission,
			@RequestHeader(value = "authorization", defaultValue = "") String auth) {

		APIResponse apiResponse = new APIResponse();
		try {
			jwtUtils.verify(auth);
		} catch (Exception e) {

			apiResponse.setStatus(401); // Unauthorized
			apiResponse.setData("Invalid or expired token");
			return ResponseEntity.status(apiResponse.getStatus()).body(apiResponse);
		}

		try {
			Permission permissionEntity = adminService.savePermissions(permission);
			apiResponse.setStatus(200);
			apiResponse.setData(permissionEntity);

		} catch (Exception e) {
			apiResponse.setStatus(500);
			apiResponse.setError(e.getMessage());
		}

		return ResponseEntity.status(apiResponse.getStatus()).body(apiResponse);
	}

	// update permission
	@PutMapping("admin/permissions")
	public ResponseEntity<APIResponse> updatePermissions(@RequestBody Permission permission,
			@RequestHeader(value = "authorization", defaultValue = "") String auth) {

		APIResponse apiResponse = new APIResponse();
		try {

			jwtUtils.verify(auth);
		} catch (Exception e) {

			apiResponse.setStatus(401); // Unauthorized
			apiResponse.setData("Invalid or expired token");
			return ResponseEntity.status(apiResponse.getStatus()).body(apiResponse);
		}

		try {
			Permission permissionEntity = adminService.savePermissions(permission);
			apiResponse.setStatus(200);
			apiResponse.setData(permissionEntity);

		} catch (Exception e) {
			apiResponse.setStatus(500);
			apiResponse.setError(e.getMessage());
		}

		return ResponseEntity.status(apiResponse.getStatus()).body(apiResponse);
	}

	// Disable roles
	@DeleteMapping("admin/permissions/{id}")
	public ResponseEntity<APIResponse> disablePermission(@PathVariable Integer id,
			@RequestHeader(value = "authorization", defaultValue = "") String auth) {

		APIResponse apiResponse = new APIResponse();
		try {

			jwtUtils.verify(auth);
		} catch (Exception e) {

			apiResponse.setStatus(401); // Unauthorized
			apiResponse.setData("Invalid or expired token");
			return ResponseEntity.status(apiResponse.getStatus()).body(apiResponse);
		}

		try {
			adminService.disablePermission(id);
			apiResponse.setStatus(200);
			apiResponse.setData("Permission disabled successfully!");

		} catch (Exception e) {
			apiResponse.setStatus(500);
			apiResponse.setError(e.getMessage());
		}

		return ResponseEntity.status(apiResponse.getStatus()).body(apiResponse);
	}

	// disable roleandpermission
	@DeleteMapping("admin/disableRolesAndPermissions/{id}")
	public ResponseEntity<APIResponse> disableRolesAndPermissions(@PathVariable Integer id) {

		APIResponse apiResponse = new APIResponse();

		try {
			adminService.disableRolesAndPermissions(id);
			apiResponse.setStatus(200);
			apiResponse.setData("Roles and Permissions disabled successfully!");

		} catch (Exception e) {
			apiResponse.setStatus(500);
			apiResponse.setError(e.getMessage());
		}

		return ResponseEntity.status(apiResponse.getStatus()).body(apiResponse);
	}

	@GetMapping("users")
	private List<User> getAllUsers() {
		return userService.getAllUsers();
	}

	// create user
	@PostMapping("users")
	public ResponseEntity<APIResponse> createUser(@RequestBody User user,
			@RequestHeader(value = "authorization", defaultValue = "")String auth) {

		APIResponse apiResponse = new APIResponse();
		try {

			jwtUtils.verify(auth);
		} catch (Exception e) {

			apiResponse.setStatus(401); // Unauthorized
			apiResponse.setData("Invalid or expired token");
			return ResponseEntity.status(apiResponse.getStatus()).body(apiResponse);
		}

		try {
			User userEntity = userService.saveUser(user);
			apiResponse.setStatus(200);
			apiResponse.setData(userEntity);

		} catch (Exception e) {
			apiResponse.setStatus(500);
			apiResponse.setError(e.getMessage());
		}

		return ResponseEntity.status(apiResponse.getStatus()).body(apiResponse);
	}

}
