package com.athira.demo.service;

import java.util.List;

import com.athira.demo.entity.ConsultationBilling;
import com.athira.demo.entity.Patient;

public interface IPatientService {

	List<Patient> getAllPatients();

	List<ConsultationBilling> getAllConsultationBillings();

	ConsultationBilling addConsultationBillings(ConsultationBilling consultationBilling, Integer userid);

	ConsultationBilling updateConsultationBillings(ConsultationBilling consultationBilling, Integer userid);

	Patient getPatientById(Integer id, Integer userId);

	
}
