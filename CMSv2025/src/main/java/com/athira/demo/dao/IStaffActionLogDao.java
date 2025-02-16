package com.athira.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.athira.demo.entity.StaffActionLog;

@Repository
public interface IStaffActionLogDao extends JpaRepository<StaffActionLog, Integer> {

}
