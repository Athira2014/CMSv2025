package com.athira.demo.service;

import java.util.List;

import com.athira.demo.entity.Permission;
import com.athira.demo.entity.Role;
import com.athira.demo.entity.RolesAndPermissions;

public interface IAdminService {

	List<Role> getAllRoles();

	List<RolesAndPermissions> getAllRolesAndPermissions();

	Role saveRoles(Role role);
	
	Permission savePermissions(Permission permission);

	RolesAndPermissions saveRolesAndPermissions(RolesAndPermissions rolesAndPermissions);

	void disableRole(Integer id);

	void disablePermission(Integer id);

	void disableRolesAndPermissions(Integer id);

	List<Permission> getAllPermissions();

	List<RolesAndPermissions> getRolesAndPermissionsByRoleId(Integer roleId);


}
