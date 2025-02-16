package com.athira.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.athira.demo.entity.LabTestPrescription;

@Repository
public interface ILabTestPrescriptionDao extends JpaRepository<LabTestPrescription, Integer> {

}
