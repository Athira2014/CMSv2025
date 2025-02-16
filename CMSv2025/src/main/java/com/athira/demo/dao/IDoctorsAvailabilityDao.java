package com.athira.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Repository;

import com.athira.demo.entity.DoctorsAvailability;

@Repository
public interface IDoctorsAvailabilityDao extends JpaRepository<DoctorsAvailability, Integer> {

	@Procedure("spGetDoctorAvailabiltyById")
	List<DoctorsAvailability> spGetDoctorAvailabiltyById(Integer id);

}
