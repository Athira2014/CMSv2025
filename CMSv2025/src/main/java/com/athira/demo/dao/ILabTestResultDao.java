package com.athira.demo.dao;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.athira.demo.entity.LabTestResult;

@Repository
public interface ILabTestResultDao extends JpaRepository<LabTestResult, Integer> {

	@Query("from LabTestResult WHERE labTestDetId = :detailId")
	List<LabTestResult> findByLabTestDetId(@Param("detailId")Integer detailId);

	@Procedure("spCreateLabTestResult")
	LabTestResult spCreateLabTestResult(Integer labTestDetId, String description, int result, String flag,
			Timestamp createdDate, boolean b);

}
