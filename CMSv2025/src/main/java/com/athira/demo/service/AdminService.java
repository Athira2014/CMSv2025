package com.athira.demo.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.athira.demo.dao.IPermissionDao;
import com.athira.demo.dao.IRoleDao;
import com.athira.demo.dao.IRolesAndPermissionsDao;
import com.athira.demo.entity.Permission;
import com.athira.demo.entity.Role;
import com.athira.demo.entity.RolesAndPermissions;

@Transactional
@Service
public class AdminService implements IAdminService {

	@Autowired
	private IRoleDao roleDao;

	@Autowired
	private IPermissionDao permissionDao;

	@Autowired
	private IRolesAndPermissionsDao rolesAndPermissionsDao;

	public List<Role> getAllRoles() {
		return roleDao.findAll();
	}

	@Transactional
	public List<RolesAndPermissions> getAllRolesAndPermissions() {
		return rolesAndPermissionsDao.findAll();
	}

	public Role saveRoles(Role role) {
		return roleDao.save(role);
	}

	public Permission savePermissions(Permission permission) {
		return permissionDao.save(permission);
	}

	public RolesAndPermissions saveRolesAndPermissions(RolesAndPermissions rolesAndPermissions) {
		return rolesAndPermissionsDao.save(rolesAndPermissions);
	}

	public void disableRole(Integer id) {
		roleDao.disableRoleById(id);
	}

	public void disablePermission(Integer id) {
		permissionDao.disablePermissionById(id);
	}

	public void disableRolesAndPermissions(Integer id) {
		rolesAndPermissionsDao.disableRolesAndPermissions(id);
	}
	
	public List<RolesAndPermissions> getRolesAndPermissionsByRoleId(Integer roleId) {
		return rolesAndPermissionsDao.findBYRoleId(roleId);
	}

	@Override
	public List<Permission> getAllPermissions() {
		return permissionDao.findAll();
	}



	
}
