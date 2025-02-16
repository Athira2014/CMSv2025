package com.athira.demo.dao;

import java.sql.Timestamp;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.athira.demo.entity.LabTestCategory;

@Repository
public interface ILabTestCategoryDao extends JpaRepository<LabTestCategory, Integer> {

	@Procedure("spAddNewLabTestCategory")
	LabTestCategory spAddNewLabTestCategory(String category, Timestamp createdDate, boolean active);

	@Modifying
	@Query("UPDATE com.athira.demo.entity.LabTestCategory SET isActive = 0 WHERE labTestCatId = :id")
	LabTestCategory disableLabTestCategories(@Param("id")Integer id);

}
