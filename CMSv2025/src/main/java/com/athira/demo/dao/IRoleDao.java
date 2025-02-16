package com.athira.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.athira.demo.entity.Role;

@Repository
public interface IRoleDao extends JpaRepository<Role, Integer> {

	@Modifying
	@Query("UPDATE com.athira.demo.entity.Role SET isActive = 0 WHERE roleId = :id")
	void disableRoleById(@Param("id") Integer id);

}
