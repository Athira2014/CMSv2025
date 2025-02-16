package com.athira.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.athira.demo.entity.StaffLogin;

@Repository
public interface IStaffLoginDao extends JpaRepository<StaffLogin, Integer>{

	// Not using stafflogin anymore instead user User
}
