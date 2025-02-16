package com.athira.demo.dao;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Repository;

import com.athira.demo.entity.LabTestDetails;
import com.athira.demo.entity.MedicinePrescription;

@Repository
public interface IMedicinePrescriptionDao extends JpaRepository<MedicinePrescription, Integer> {

	@Procedure("spGetMedicalPrescriptionByAppointmentId")
	List<MedicinePrescription> spGetMedicalPrescriptionByAppointmentId(Integer appointmentId);

	@Procedure("spGetMedPrescriptionForAPatient")
	List<MedicinePrescription> spGetMedPrescriptionForAPatient(Integer id);

	@Procedure("spCreateMedicalPrescription")
	MedicinePrescription spCreateMedicalPrescription(Integer appointmentId, String medicines, Integer dosage,
			String frequency, Timestamp createdDateTimeStamp);

}
