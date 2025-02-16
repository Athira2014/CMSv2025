package com.athira.demo.dao;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.athira.demo.entity.Doctor;

@Repository
public interface IDoctorDao extends JpaRepository<Doctor, Integer>{

	@Modifying
	@Query("UPDATE com.athira.demo.entity.Doctor SET isActive = 0 WHERE docId = :id")
	Doctor disableDoctor(@Param("id") Integer id);

	@Procedure("spAddNewDoctor")
	Doctor spAddNewDoctor(Integer staffId, Integer specializationId, double fee, String licenceNo,
			Timestamp createdDateTimeStamp, boolean b);

	@Procedure("spGetDoctorById")
	Doctor spGetDoctorById(Integer id);

	@Procedure("spUpdateDoctor")
	Doctor spUpdateDoctor(Integer staffId, Integer specializationId, double fee, String licenceNo, Integer docId);

	@Procedure("spListingDoctors")
	List<Doctor> spListingDoctors(Integer roleId, String permission);

}
