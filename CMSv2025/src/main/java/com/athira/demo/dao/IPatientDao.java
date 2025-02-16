package com.athira.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Repository;

import com.athira.demo.entity.Patient;

@Repository
public interface IPatientDao extends JpaRepository<Patient, Integer> {

	@Procedure("spGetPatientById")
	Patient spGetPatientById(Integer id);

}
