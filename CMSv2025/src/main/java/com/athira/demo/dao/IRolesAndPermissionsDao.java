package com.athira.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.athira.demo.entity.RolesAndPermissions;

@Repository
public interface IRolesAndPermissionsDao extends JpaRepository<RolesAndPermissions, Integer> {

	@Modifying
	@Query("UPDATE com.athira.demo.entity.RolesAndPermissions SET isActive = 0 WHERE roleAndPermId = :id")
	void disableRolesAndPermissions(@Param("id")Integer id);

	@Query("from RolesAndPermissions WHERE roleId = :roleId")
	List<RolesAndPermissions> findBYRoleId(@Param("roleId")Integer roleId);

}
