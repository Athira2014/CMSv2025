package com.athira.demo.service;

import java.sql.Timestamp;
import java.util.List;
import java.util.concurrent.ExecutorService;

import javax.transaction.Transactional;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.athira.demo.dao.IConsultationNoteDao;
import com.athira.demo.dao.IDoctorDao;
import com.athira.demo.dao.IDoctorsAvailabilityDao;
import com.athira.demo.dao.IMedicinePrescriptionDao;
import com.athira.demo.dao.ISpecializationDao;
import com.athira.demo.entity.ConsultationNote;
import com.athira.demo.entity.Doctor;
import com.athira.demo.entity.DoctorsAvailability;
import com.athira.demo.entity.MedicinePrescription;
import com.athira.demo.entity.Role;
import com.athira.demo.entity.Specialization;

@Transactional
@Service
public class DoctorService implements IDoctorService {

	@Autowired
	IDoctorDao doctorDao;

	@Autowired
	IDoctorsAvailabilityDao doctorsAvailabilityDao;

	@Autowired
	ISpecializationDao specializationDao;

	@Autowired
	ExecutorService executorService;

	@Autowired
	IConsultationNoteDao consultationNoteDao;

	@Autowired
	IMedicinePrescriptionDao medicinePrescriptionDao;
	
	@Autowired
	private StaffService staffService;
	
	@Transactional
	public List<DoctorsAvailability> getAllDoctorsAvailability() {
		return doctorsAvailabilityDao.findAll();
	}

	public List<Doctor> getAllDoctors() {
		return doctorDao.findAll();
	}
	
	public List<Specialization> getAllSpecializations() {
		return specializationDao.findAll();
	}

	public Doctor addDoctor(Doctor doctor) {

		if (doctor.getDocId() == null && doctor.getCreatedDate() == null) {
			doctor.setCreatedDate(new DateTime());
		}
		try {
			Timestamp createdDateTimeStamp = new Timestamp(System.currentTimeMillis());
			return doctorDao.spAddNewDoctor(doctor.getStaffId(), doctor.getSpecializationId(), doctor.getFee(),
					doctor.getLicenceNo(), createdDateTimeStamp, true);
		} catch (DataAccessException e) {
			e.printStackTrace();
			throw new RuntimeException("Data access exception occured when saving doctor.");
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("UnExcepted exception occured when saving doctor.");
		}
	}

	public Doctor updateDoctor(Doctor doctor) {

		try {
			return doctorDao.spUpdateDoctor(doctor.getStaffId(), doctor.getSpecializationId(), doctor.getFee(),
					doctor.getLicenceNo(), doctor.getDocId());
		} catch (DataAccessException e) {
			e.printStackTrace();
			throw new RuntimeException("Data access exception occured when saving doctor.");
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("UnExcepted exception occured when saving doctor.");
		}
	}

	public Doctor disableDoctor(Integer id) {

		try {
			return doctorDao.disableDoctor(id);
		} catch (DataAccessException e) {
			e.printStackTrace();
			throw new RuntimeException("Data access exception occured when saving doctor.");
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("UnExcepted exception occured when saving doctor.");
		}
	}

	public Specialization saveSpecialization(Specialization specialization) {

		try {
			return specializationDao.save(specialization);
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
			throw new RuntimeException("Invalid Input error.");
		} catch (DataAccessException e) {
			e.printStackTrace();
			throw new RuntimeException("Data access exception occured when saving doctor.");
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("UnExcepted exception occured when saving doctor.");
		}
	}

	public void deleteSpecialization(Integer id) {
		doctorDao.deleteById(id);
	}

	public DoctorsAvailability saveDoctorsAvailability(DoctorsAvailability doctorsAvailability) {
		try {
			return doctorsAvailabilityDao.save(doctorsAvailability);
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
			throw new RuntimeException("Invalid Input error.");
		} catch (DataAccessException e) {
			e.printStackTrace();
			throw new RuntimeException("Data access exception occured when saving doctor's Availability.");
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("UnExcepted exception occured when saving doctor's Availability.");
		}
	}

	public void deleteDoctorsAvailability(Integer id) {
		doctorsAvailabilityDao.deleteById(id);
	}

	public List<DoctorsAvailability> getAllDoctorsAvailabilityById(Integer id) {
		
		try {
			return doctorsAvailabilityDao.spGetDoctorAvailabiltyById(id);

		} catch (IllegalArgumentException e) {
			e.printStackTrace();
			throw new RuntimeException("Invalid input: doctors id error.");
		} catch (DataAccessException e) {
			e.printStackTrace();
			throw new RuntimeException("Data access exception occured when fetching doctor's Availability by id.");
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("UnExcepted exception occured when  fetching doctor's Availability by id.");
		}
	}

	public Doctor getDoctorById(Integer id) {
		try {
			return doctorDao.spGetDoctorById(id);

		} catch (IllegalArgumentException e) {
			e.printStackTrace();
			throw new RuntimeException("Invalid input: doctors id error.");
		} catch (DataAccessException e) {
			e.printStackTrace();
			throw new RuntimeException("Data access exception occured when fetching doctor by id.");
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("UnExcepted exception occured when  fetching doctor by id.");
		}
	}

	public List<Doctor> getAllDoctors(Integer userid) {

		Role role = staffService.getUserRoleByUserId(userid);
		String permission = "VIEW_DOCTOR";
		boolean hasPermission = staffService.checkIfUserHasPermission(role.getRoleId(), permission);

		// If no permission found, throw an exception
		if (!hasPermission) {
			throw new IllegalArgumentException("User does not have the permission to view doctors.");
		}
		
		return doctorDao.spListingDoctors(role.getRoleId(), permission);
	}

	public DoctorsAvailability addDoctorsAvailability(DoctorsAvailability doctorsAvailability) {
		return saveDoctorsAvailability(doctorsAvailability);
	}

	public ConsultationNote addConsultationNote(ConsultationNote consultationNote, Integer staffid) {
		
		Role role = staffService.getUserRoleByUserId(staffid);
		String permission = "ADD_CONSULTATION_NOTE";
		boolean hasPermission = staffService.checkIfUserHasPermission(role.getRoleId(), permission);

		// If no permission found, throw an exception
		if (!hasPermission) {
			throw new IllegalArgumentException("User does not have the permission to add consultationNote.");
		}
		
		return consultationNoteDao.spCreateConsultationNotes(consultationNote.getAppointmentId(), consultationNote.getSymptoms(),
				consultationNote.getDiagnosis(), consultationNote.getFollowUp());
	}

	public MedicinePrescription addPrescription(MedicinePrescription medicinePrescription, Integer staffid) {
		
		Role role = staffService.getUserRoleByUserId(staffid);
		String permission = "ADD_PRESCRIPTION";
		boolean hasPermission = staffService.checkIfUserHasPermission(role.getRoleId(), permission);

		// If no permission found, throw an exception
		if (!hasPermission) {
			throw new IllegalArgumentException("User does not have the permission to add prescription.");
		}
		
		Timestamp createdDateTimeStamp = new Timestamp(System.currentTimeMillis());

		
		return medicinePrescriptionDao.spCreateMedicalPrescription(medicinePrescription.getAppointmentId(),
				medicinePrescription.getMedicines(), medicinePrescription.getDosage(), medicinePrescription.getFrequency(),
				createdDateTimeStamp);
	}

	public List<ConsultationNote> getConsultationNoteByPatientId(Integer patientId) {
		return consultationNoteDao.spGetConsultationNotesByPatientId(patientId);
	}

}
