package com.athira.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.athira.demo.common.APIResponse;
import com.athira.demo.entity.Appointment;
import com.athira.demo.entity.ConsultationBilling;
import com.athira.demo.entity.ConsultationNote;
import com.athira.demo.entity.Patient;
import com.athira.demo.service.IAppointmentService;
import com.athira.demo.service.IDoctorService;
import com.athira.demo.service.IPatientService;
import com.athira.demo.util.JwtUtils;

@RestController
@RequestMapping("api/")
public class ReceptionController {

	@Autowired
	IAppointmentService appointmentService;

	@Autowired
	IPatientService patientService;

	@Autowired
	IDoctorService doctorService;

	@Autowired
	JwtUtils jwtUtils;

	@GetMapping("appointments")
	public ResponseEntity<APIResponse> getAllAppointments(
			@RequestHeader(value = "authorization", defaultValue = "") String auth) {

		APIResponse apiResponse = new APIResponse();

		// Authorizing JWT
		ResponseEntity<APIResponse> tokenResponse = jwtUtils.verifyToken(auth);

		if (tokenResponse == null) {
			return tokenResponse;
		}

		try {
			List<Appointment> appointments = appointmentService.getAllAppointments();
			apiResponse.setStatus(200);
			apiResponse.setData(appointments);

		} catch (Exception e) {
			apiResponse.setStatus(500);
			apiResponse.setError(e.getMessage());
		}

		return ResponseEntity.status(apiResponse.getStatus()).body(apiResponse);
	}

	@GetMapping("patients")
	public ResponseEntity<APIResponse> getAllPatients(
			@RequestHeader(value = "authorization", defaultValue = "") String auth) {

		APIResponse apiResponse = new APIResponse();

		// Authorizing JWT
		ResponseEntity<APIResponse> tokenResponse = jwtUtils.verifyToken(auth);

		if (tokenResponse == null) {
			return tokenResponse;
		}

		try {
			List<Patient> patients = patientService.getAllPatients();
			apiResponse.setStatus(200);
			apiResponse.setData(patients);

		} catch (Exception e) {
			apiResponse.setStatus(500);
			apiResponse.setError(e.getMessage());
		}

		return ResponseEntity.status(apiResponse.getStatus()).body(apiResponse);
	}

	@GetMapping("patients/{id}/{userId}")
	public ResponseEntity<APIResponse> getPatientById(@PathVariable Integer id, @PathVariable Integer userId,
			@RequestHeader(value = "authorization", defaultValue = "") String auth) {

		APIResponse apiResponse = new APIResponse();

		// Authorizing JWT
		ResponseEntity<APIResponse> tokenResponse = jwtUtils.verifyToken(auth);

		if (tokenResponse == null) {
			return tokenResponse;
		}

		try {
			Patient patient = patientService.getPatientById(id, userId);
			apiResponse.setStatus(200);
			apiResponse.setData(patient);

		} catch (Exception e) {
			apiResponse.setStatus(500);
			apiResponse.setError(e.getMessage());
		}

		return ResponseEntity.status(apiResponse.getStatus()).body(apiResponse);
	}

	@GetMapping("billings")
	public ResponseEntity<APIResponse> getAllConsultationBillings(
			@RequestHeader(value = "authorization", defaultValue = "") String auth) {

		APIResponse apiResponse = new APIResponse();

		// Authorizing JWT
		ResponseEntity<APIResponse> tokenResponse = jwtUtils.verifyToken(auth);

		if (tokenResponse == null) {
			return tokenResponse;
		}

		try {
			List<ConsultationBilling> billings = patientService.getAllConsultationBillings();
			apiResponse.setStatus(200);
			apiResponse.setData(billings);

		} catch (Exception e) {
			apiResponse.setStatus(500);
			apiResponse.setError(e.getMessage());
		}

		return ResponseEntity.status(apiResponse.getStatus()).body(apiResponse);
	}

	@PostMapping("billings/{userid}")
	public ResponseEntity<APIResponse> addConsultationBillings(@RequestBody ConsultationBilling consultationBilling,
			@PathVariable Integer userid,
			@RequestHeader(value = "authorization", defaultValue = "") String auth) {

		APIResponse apiResponse = new APIResponse();
		// Authorizing JWT
		ResponseEntity<APIResponse> tokenResponse = jwtUtils.verifyToken(auth);

		if (tokenResponse == null) {
			return tokenResponse;
		}
		try {
			ConsultationBilling consultationBillingEntity = patientService.addConsultationBillings(consultationBilling,
					userid);
			apiResponse.setStatus(200);
			apiResponse.setData(consultationBillingEntity);

		} catch (Exception e) {
			apiResponse.setStatus(500);
			apiResponse.setError(e.getMessage());
		}

		return ResponseEntity.status(apiResponse.getStatus()).body(apiResponse);
	}

	@PutMapping("billings/{userid}")
	public ResponseEntity<APIResponse> updateConsultationBillings(@RequestBody ConsultationBilling consultationBilling,
			@PathVariable Integer userid,
			@RequestHeader(value = "authorization", defaultValue = "") String auth) {

		APIResponse apiResponse = new APIResponse();
		// Authorizing JWT
		ResponseEntity<APIResponse> tokenResponse = jwtUtils.verifyToken(auth);

		if (tokenResponse == null) {
			return tokenResponse;
		}
		try {
			ConsultationBilling consultationBillingEntity = patientService
					.updateConsultationBillings(consultationBilling, userid);
			apiResponse.setStatus(200);
			apiResponse.setData(consultationBillingEntity);

		} catch (Exception e) {
			apiResponse.setStatus(500);
			apiResponse.setError(e.getMessage());
		}

		return ResponseEntity.status(apiResponse.getStatus()).body(apiResponse);
	}

	@PostMapping("appointments/{userid}")
	public ResponseEntity<APIResponse> createAppointment(@RequestBody Appointment appointment,
			@PathVariable Integer userid,
			@RequestHeader(value = "authorization", defaultValue = "") String auth) {

		APIResponse apiResponse = new APIResponse();
		// Authorizing JWT
		ResponseEntity<APIResponse> tokenResponse = jwtUtils.verifyToken(auth);

		if (tokenResponse == null) {
			return tokenResponse;
		}
		try {
			Appointment appointmentEntity = appointmentService.saveAppointment(appointment, userid, "ADD_APPOINTMENT");
			apiResponse.setStatus(200);
			apiResponse.setData(appointmentEntity);

		} catch (Exception e) {
			apiResponse.setStatus(500);
			apiResponse.setError(e.getMessage());
		}

		return ResponseEntity.status(apiResponse.getStatus()).body(apiResponse);
	}

	@PutMapping("appointments/{userid}")
	public ResponseEntity<APIResponse> updateAppointment(@RequestBody Appointment appointment,
			@PathVariable Integer userid,
			@RequestHeader(value = "authorization", defaultValue = "") String auth) {

		APIResponse apiResponse = new APIResponse();
		// Authorizing JWT
		ResponseEntity<APIResponse> tokenResponse = jwtUtils.verifyToken(auth);

		if (tokenResponse == null) {
			return tokenResponse;
		}
		try {
			Appointment appointmentEntity = appointmentService.saveAppointment(appointment, userid,
					"UPDATE_APPOINTMENT");
			apiResponse.setStatus(200);
			apiResponse.setData(appointmentEntity);

		} catch (Exception e) {
			apiResponse.setStatus(500);
			apiResponse.setError(e.getMessage());
		}

		return ResponseEntity.status(apiResponse.getStatus()).body(apiResponse);
	}

	@GetMapping("consultationnote/{id}")
	public ResponseEntity<APIResponse> getConsultationNoteById(@PathVariable Integer id,
			@RequestHeader(value = "authorization", defaultValue = "") String auth) {

		APIResponse apiResponse = new APIResponse();
		// Authorizing JWT
		ResponseEntity<APIResponse> tokenResponse = jwtUtils.verifyToken(auth);

		if (tokenResponse == null) {
			return tokenResponse;
		}
		
		try {
			List<ConsultationNote> appointmentEntity = doctorService.getConsultationNoteByPatientId(id);
			apiResponse.setStatus(200);
			apiResponse.setData(appointmentEntity);

		} catch (Exception e) {
			apiResponse.setStatus(500);
			apiResponse.setError(e.getMessage());
		}

		return ResponseEntity.status(apiResponse.getStatus()).body(apiResponse);

	}
}
