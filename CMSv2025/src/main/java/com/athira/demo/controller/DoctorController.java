package com.athira.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.athira.demo.common.APIResponse;
import com.athira.demo.entity.ConsultationNote;
import com.athira.demo.entity.Doctor;
import com.athira.demo.entity.DoctorsAvailability;
import com.athira.demo.entity.MedicinePrescription;
import com.athira.demo.entity.Specialization;
import com.athira.demo.service.IDoctorService;
import com.athira.demo.util.JwtUtils;

@RestController
@RequestMapping("api/")
public class DoctorController {

	@Autowired
	IDoctorService doctorService;

	@Autowired
	JwtUtils jwtUtils;

	// List of Doctors
	@GetMapping("doctors/{userid}")
	public List<Doctor> getAllDoctors(@PathVariable Integer userid) {
		return doctorService.getAllDoctors(userid);

	}

	// List of Doctors
	@GetMapping("doctors/{id}")
	public Doctor getDoctorById(@PathVariable Integer id) {
		return doctorService.getDoctorById(id);

	}

	// Get Doctor's availability
	@GetMapping("doctorAvailability")
	public List<DoctorsAvailability> getAllDoctorsAvailability() {
		return doctorService.getAllDoctorsAvailability();
	}

	// Get Doctor's availability by id
	@GetMapping("doctorAvailability/{id}")
	public List<DoctorsAvailability> getAllDoctorsAvailabilityById(@PathVariable Integer id) {
		return doctorService.getAllDoctorsAvailabilityById(id);
	}

	// Get specializations
	@GetMapping("specializations")
	public ResponseEntity<APIResponse> getAllSpecializations(
			@RequestHeader(value = "authorization", defaultValue = "") String auth) {

		ResponseEntity<APIResponse> tokenVerificationResponse = jwtUtils.verifyToken(auth);

		// Return the response if the token is invalid/expired
		if (tokenVerificationResponse != null) {
			return tokenVerificationResponse;
		}
		APIResponse apiResponse = new APIResponse();
		try {
			List<Specialization> specializations = doctorService.getAllSpecializations();
			apiResponse.setStatus(200);
			apiResponse.setData(specializations);

		} catch (Exception e) {
			apiResponse.setStatus(500);
			apiResponse.setError(e.getMessage());
		}

		return ResponseEntity.status(apiResponse.getStatus()).body(apiResponse);
	}

	// create specializations
	@PostMapping("specializations")
	public ResponseEntity<APIResponse> addSpecialization(@RequestBody Specialization specialization,
			@RequestHeader(value = "authorization", defaultValue = "") String auth) {

		APIResponse apiResponse = new APIResponse();
		ResponseEntity<APIResponse> tokenVerificationResponse = jwtUtils.verifyToken(auth);

		// Return the response if the token is invalid/expired
		if (tokenVerificationResponse != null) {
			return tokenVerificationResponse;
		}

		try {
			Specialization specializationEntity = doctorService.saveSpecialization(specialization);
			apiResponse.setStatus(200);
			apiResponse.setData(specializationEntity);

		} catch (Exception e) {
			apiResponse.setStatus(500);
			apiResponse.setError(e.getMessage());
		}

		return ResponseEntity.status(apiResponse.getStatus()).body(apiResponse);
	}

	// Update specializations
	@PutMapping("specializations")
	public ResponseEntity<APIResponse> updateSpecialization(@RequestBody Specialization specialization,
			@RequestHeader(value = "authorization", defaultValue = "") String auth) {

		APIResponse apiResponse = new APIResponse();

		// authorization
		ResponseEntity<APIResponse> tokenVerificationResponse = jwtUtils.verifyToken(auth);

		// Return the response if the token is invalid/expired
		if (tokenVerificationResponse != null) {
			return tokenVerificationResponse;
		}

		try {
			Specialization specializationEntity = doctorService.saveSpecialization(specialization);
			apiResponse.setStatus(200);
			apiResponse.setData(specializationEntity);

		} catch (Exception e) {
			apiResponse.setStatus(500);
			apiResponse.setError(e.getMessage());
		}

		return ResponseEntity.status(apiResponse.getStatus()).body(apiResponse);
	}

	// Delete specializations
	@DeleteMapping("specializations/{id}")
	public ResponseEntity<APIResponse> deleteSpecialization(@PathVariable Integer id,
			@RequestHeader(value = "authorization", defaultValue = "") String auth) {

		APIResponse apiResponse = new APIResponse();

		// authorization
		ResponseEntity<APIResponse> tokenVerificationResponse = jwtUtils.verifyToken(auth);

		// Return the response if the token is invalid/expired
		if (tokenVerificationResponse != null) {
			return tokenVerificationResponse;
		}

		try {
			doctorService.deleteSpecialization(id);
			apiResponse.setStatus(200);
			apiResponse.setData("Specialization deleted succesfully.");

		} catch (Exception e) {
			apiResponse.setStatus(500);
			apiResponse.setError(e.getMessage());
		}

		return ResponseEntity.status(apiResponse.getStatus()).body(apiResponse);
	}

	// create doctors
	@PostMapping("doctors")
	public ResponseEntity<APIResponse> addDoctor(@RequestBody Doctor doctor,
			@RequestHeader(value = "authorization", defaultValue = "") String auth) {

		// authorization
		ResponseEntity<APIResponse> tokenVerificationResponse = jwtUtils.verifyToken(auth);

		// Return the response if the token is invalid/expired
		if (tokenVerificationResponse != null) {
			return tokenVerificationResponse;
		}

		APIResponse apiResponse = new APIResponse();

		try {
			Doctor doctorEntity = doctorService.addDoctor(doctor);
			apiResponse.setStatus(200);
			apiResponse.setData(doctorEntity);

		} catch (Exception e) {
			apiResponse.setStatus(500);
			apiResponse.setError(e.getMessage());
		}

		return ResponseEntity.status(apiResponse.getStatus()).body(apiResponse);
	}

	// Update doctors
	@PutMapping("doctors")
	public ResponseEntity<APIResponse> updateDoctor(@RequestBody Doctor doctor,
			@RequestHeader(value = "authorization", defaultValue = "") String auth) {

		// authorization
		ResponseEntity<APIResponse> tokenVerificationResponse = jwtUtils.verifyToken(auth);

		// Return the response if the token is invalid/expired
		if (tokenVerificationResponse != null) {
			return tokenVerificationResponse;
		}

		APIResponse apiResponse = new APIResponse();

		try {
			Doctor doctorEntity = doctorService.updateDoctor(doctor);
			apiResponse.setStatus(200);
			apiResponse.setData(doctorEntity);

		} catch (Exception e) {
			apiResponse.setStatus(500);
			apiResponse.setError(e.getMessage());
		}

		return ResponseEntity.status(apiResponse.getStatus()).body(apiResponse);
	}

	// Disable doctors
	@DeleteMapping("doctors/{id}")
	public ResponseEntity<APIResponse> disableDoctor(@PathVariable Integer id,
			@RequestHeader(value = "authorization", defaultValue = "") String auth) {

		// authorization
		ResponseEntity<APIResponse> tokenVerificationResponse = jwtUtils.verifyToken(auth);

		// Return the response if the token is invalid/expired
		if (tokenVerificationResponse != null) {
			return tokenVerificationResponse;
		}

		APIResponse apiResponse = new APIResponse();

		try {
			Doctor doctorEntity = doctorService.disableDoctor(id);
			apiResponse.setStatus(200);
			apiResponse.setData(doctorEntity);

		} catch (Exception e) {
			apiResponse.setStatus(500);
			apiResponse.setError(e.getMessage());
		}

		return ResponseEntity.status(apiResponse.getStatus()).body(apiResponse);
	}

	// create doctorsAvailability
	@PostMapping("doctorsavailability")
	public ResponseEntity<APIResponse> addDoctorsAvailability(@RequestBody DoctorsAvailability doctorsAvailability,
			@RequestHeader(value = "authorization", defaultValue = "") String auth) {

		// authorization
		ResponseEntity<APIResponse> tokenVerificationResponse = jwtUtils.verifyToken(auth);

		// Return the response if the token is invalid/expired
		if (tokenVerificationResponse != null) {
			return tokenVerificationResponse;
		}

		APIResponse apiResponse = new APIResponse();

		try {
			DoctorsAvailability doctorsAvailabilityEntity = doctorService.addDoctorsAvailability(doctorsAvailability);
			apiResponse.setStatus(200);
			apiResponse.setData(doctorsAvailabilityEntity);

		} catch (Exception e) {
			apiResponse.setStatus(500);
			apiResponse.setError(e.getMessage());
		}

		return ResponseEntity.status(apiResponse.getStatus()).body(apiResponse);
	}

	// update doctorsAvailability
	@PutMapping("doctorsavailability")
	public ResponseEntity<APIResponse> updateDoctorsAvailability(@RequestBody DoctorsAvailability doctorsAvailability,
			@RequestHeader(value = "authorization", defaultValue = "") String auth) {

		// authorization
		ResponseEntity<APIResponse> tokenVerificationResponse = jwtUtils.verifyToken(auth);

		// Return the response if the token is invalid/expired
		if (tokenVerificationResponse != null) {
			return tokenVerificationResponse;
		}

		APIResponse apiResponse = new APIResponse();

		try {
			DoctorsAvailability doctorsAvailabilityEntity = doctorService.saveDoctorsAvailability(doctorsAvailability);
			apiResponse.setStatus(200);
			apiResponse.setData(doctorsAvailabilityEntity);

		} catch (Exception e) {
			apiResponse.setStatus(500);
			apiResponse.setError(e.getMessage());
		}

		return ResponseEntity.status(apiResponse.getStatus()).body(apiResponse);
	}

	// Delete doctorsAvailability
	@DeleteMapping("doctorsAvailability/{id}")
	public ResponseEntity<APIResponse> deleteDoctorsAvailability(@PathVariable Integer id,
			@RequestHeader(value = "authorization", defaultValue = "") String auth) {

		// authorization
		ResponseEntity<APIResponse> tokenVerificationResponse = jwtUtils.verifyToken(auth);

		// Return the response if the token is invalid/expired
		if (tokenVerificationResponse != null) {
			return tokenVerificationResponse;
		}

		APIResponse apiResponse = new APIResponse();

		try {
			doctorService.deleteDoctorsAvailability(id);
			apiResponse.setStatus(200);
			apiResponse.setData("Doctors availability record deleted.");

		} catch (Exception e) {
			apiResponse.setStatus(500);
			apiResponse.setError(e.getMessage());
		}

		return ResponseEntity.status(apiResponse.getStatus()).body(apiResponse);
	}

	// create consultationnote
	@PostMapping("consultationnote/{staffid}")
	public ResponseEntity<APIResponse> addConsultationNote(@RequestBody ConsultationNote consultationNote,
			@PathVariable Integer staffid, @RequestHeader(value = "authorization", defaultValue = "") String auth) {

		// authorization
		ResponseEntity<APIResponse> tokenVerificationResponse = jwtUtils.verifyToken(auth);

		// Return the response if the token is invalid/expired
		if (tokenVerificationResponse != null) {
			return tokenVerificationResponse;
		}

		APIResponse apiResponse = new APIResponse();

		try {
			ConsultationNote consultationNoteEntity = doctorService.addConsultationNote(consultationNote, staffid);
			apiResponse.setStatus(200);
			apiResponse.setData(consultationNoteEntity);

		} catch (Exception e) {
			apiResponse.setStatus(500);
			apiResponse.setError(e.getMessage());
		}

		return ResponseEntity.status(apiResponse.getStatus()).body(apiResponse);
	}

	// create medicineprescriptions
	@PostMapping("medicineprescription/{staffid}")
	public ResponseEntity<APIResponse> addPrescription(@RequestBody MedicinePrescription medicinePrescription,
			@PathVariable Integer staffid, @RequestHeader(value = "authorization", defaultValue = "") String auth) {

		// authorization
		ResponseEntity<APIResponse> tokenVerificationResponse = jwtUtils.verifyToken(auth);

		// Return the response if the token is invalid/expired
		if (tokenVerificationResponse != null) {
			return tokenVerificationResponse;
		}

		APIResponse apiResponse = new APIResponse();

		try {
			MedicinePrescription medicinePrescriptionEntity = doctorService.addPrescription(medicinePrescription,
					staffid);
			apiResponse.setStatus(200);
			apiResponse.setData(medicinePrescriptionEntity);

		} catch (Exception e) {
			apiResponse.setStatus(500);
			apiResponse.setError(e.getMessage());
		}

		return ResponseEntity.status(apiResponse.getStatus()).body(apiResponse);
	}

}
