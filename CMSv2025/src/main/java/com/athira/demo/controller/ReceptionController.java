package com.athira.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

@RestController
@RequestMapping("api/")
public class ReceptionController {

	@Autowired
	IAppointmentService appointmentService;
	
	@Autowired
	IPatientService patientService;
	
	@Autowired
	IDoctorService doctorService;
	
	@GetMapping("appointments")
	public List<Appointment> getAllAppointments() {
		return appointmentService.getAllAppointments();
		
	}
	
	@GetMapping("patients")
	public List<Patient> getAllPatients() {
		return patientService.getAllPatients();
	}
	
	@GetMapping("patients/{id}/{userId}")
	public Patient getPatientById(@PathVariable Integer id, @PathVariable Integer userId) {
		return patientService.getPatientById(id, userId);
	}
	
	@GetMapping("billings")
	public List<ConsultationBilling> getAllConsultationBillings() {
		return patientService.getAllConsultationBillings();
	}
	
	@PostMapping("billings/{userid}")
	public ResponseEntity<APIResponse> addConsultationBillings(@RequestBody ConsultationBilling consultationBilling, 
			@PathVariable Integer userid) {

		APIResponse apiResponse = new APIResponse();

		try {
			ConsultationBilling consultationBillingEntity = patientService.addConsultationBillings(consultationBilling, userid);
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
			@PathVariable Integer userid) {

		APIResponse apiResponse = new APIResponse();

		try {
			ConsultationBilling consultationBillingEntity = patientService.updateConsultationBillings(consultationBilling, userid);
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
			@PathVariable Integer userid) {

		APIResponse apiResponse = new APIResponse();

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
			@PathVariable Integer userid) {

		APIResponse apiResponse = new APIResponse();

		try {
			Appointment appointmentEntity = appointmentService.saveAppointment(appointment, userid, "UPDATE_APPOINTMENT");
			apiResponse.setStatus(200);
			apiResponse.setData(appointmentEntity);

		} catch (Exception e) {
			apiResponse.setStatus(500);
			apiResponse.setError(e.getMessage());
		}

		return ResponseEntity.status(apiResponse.getStatus()).body(apiResponse);
	}
	
	@GetMapping("consultationnote/{id}")
	public ResponseEntity<APIResponse> getConsultationNoteById(@PathVariable Integer id) {

		APIResponse apiResponse = new APIResponse();

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
