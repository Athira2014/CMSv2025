package com.athira.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.athira.demo.entity.Permission;

@Repository
public interface IPermissionDao extends JpaRepository<Permission, Integer> {

	@Modifying
	@Query("UPDATE com.athira.demo.entity.Permission SET isActive = 0 WHERE permissionId = :id")
	void disablePermissionById(@Param("id")Integer id);

}
