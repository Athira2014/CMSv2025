package com.athira.demo.service;

import java.util.List;

import com.athira.demo.entity.ConsultationNote;
import com.athira.demo.entity.Doctor;
import com.athira.demo.entity.DoctorsAvailability;
import com.athira.demo.entity.MedicinePrescription;
import com.athira.demo.entity.Specialization;

public interface IDoctorService {

	List<Doctor> getAllDoctors();

	List<DoctorsAvailability> getAllDoctorsAvailability();

	List<Specialization> getAllSpecializations();

	Doctor addDoctor(Doctor doctor);

	Doctor disableDoctor(Integer id);

	Doctor updateDoctor(Doctor doctor);

	Specialization saveSpecialization(Specialization specialization);

	void deleteSpecialization(Integer id);

	DoctorsAvailability saveDoctorsAvailability(DoctorsAvailability doctorsAvailability);

	void deleteDoctorsAvailability(Integer id);

	List<DoctorsAvailability> getAllDoctorsAvailabilityById(Integer id);

	Doctor getDoctorById(Integer id);

	List<Doctor> getAllDoctors(Integer userid);

	DoctorsAvailability addDoctorsAvailability(DoctorsAvailability doctorsAvailability);

	ConsultationNote addConsultationNote(ConsultationNote consultationNote, Integer staffid);

	MedicinePrescription addPrescription(MedicinePrescription medicinePrescription, Integer staffid);

	List<ConsultationNote> getConsultationNoteByPatientId(Integer id);

}
