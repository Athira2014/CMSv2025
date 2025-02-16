package com.athira.demo.dao;

import org.joda.time.DateTime;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.athira.demo.entity.LabTest;

@Repository
public interface ILabTestDao extends JpaRepository<LabTest, Integer> {

	@Procedure("spAddNewLabTests")
	LabTest spAddNewLabTests(Integer labTestCatId, String testName, String description, String parameters,
			DateTime createdDateTime, boolean b);

	@Modifying
	@Query("UPDATE com.athira.demo.entity.LabTest SET isActive = 0 WHERE labTestsId = :id")
	LabTest disableLabTest(@Param("id") Integer id);

	@Procedure("spUpdateLabTests")
	LabTest spUpdateLabTests(Integer labTestCatId, String testName, String description, String parameters,
			Integer labTestsId, DateTime createdDate, Boolean active);

}
