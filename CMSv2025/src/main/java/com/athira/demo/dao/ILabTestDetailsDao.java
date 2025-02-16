package com.athira.demo.dao;

import java.sql.Timestamp;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Repository;

import com.athira.demo.entity.LabTestDetails;

@Repository
public interface ILabTestDetailsDao extends JpaRepository<LabTestDetails, Integer> {

	
	@Procedure("spCreateLabTestDetails")
	LabTestDetails spCreateLabTestDetails(Integer labPrescId, Timestamp createdDate, String remarks, boolean b);


}
