package com.athira.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.athira.demo.entity.StaffAttendance;

@Repository
public interface IStaffAttendanceDao extends JpaRepository<StaffAttendance, Integer> {

}
