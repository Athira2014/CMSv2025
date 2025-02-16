package com.athira.demo.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.athira.demo.dao.IConsutationBillingDao;
import com.athira.demo.dao.IPatientDao;
import com.athira.demo.entity.ConsultationBilling;
import com.athira.demo.entity.Patient;
import com.athira.demo.entity.Role;

@Service
public class PatientService implements IPatientService {

	@Autowired
	IPatientDao patientDao;

	@Autowired
	IConsutationBillingDao billingDao;
	
	@Autowired
	private StaffService staffService;
	
	@Transactional
	public List<Patient> getAllPatients() {
		return patientDao.findAll();
	}

	@Transactional
	public List<ConsultationBilling> getAllConsultationBillings() {
		return billingDao.findAll();
	}

	public ConsultationBilling addConsultationBillings(ConsultationBilling billing, Integer userid) {
		
		Role role = staffService.getUserRoleByUserId(userid);
		String permission = "ADD_CONSULTATION_BILLING";
		boolean hasPermission = staffService.checkIfUserHasPermission(role.getRoleId(), permission);

		// If no permission found, throw an exception
		if (!hasPermission) {
			throw new IllegalArgumentException("User does not have the permission to add consultation billing.");
		}
		
		return billingDao.spCreateConsultationBilling(billing.getAppointmentId(), billing.getAdditionalCostAny(), billing.getTotalAmount(),
				billing.getAmountPaid(), billing.getOutstandingAmt(), billing.getBillingDate(), billing.getPaymentStatus());
	}

	public ConsultationBilling updateConsultationBillings(ConsultationBilling consultationBilling, Integer userid) {

		Role role = staffService.getUserRoleByUserId(userid);
		String permission = "UPDATE_CONSULTATION_BILLING";
		boolean hasPermission = staffService.checkIfUserHasPermission(role.getRoleId(), permission);

		// If no permission found, throw an exception
		if (!hasPermission) {
			throw new IllegalArgumentException("User does not have the permission to update consultation billing.");
		}
		
		return billingDao.save(consultationBilling);
	}


	public Patient getPatientById(Integer id, Integer userId) {
		
		Role role = staffService.getUserRoleByUserId(userId);
		String permission = "VIEW_PATIENT";
		boolean hasPermission = staffService.checkIfUserHasPermission(role.getRoleId(), permission);

		// If no permission found, throw an exception
		if (!hasPermission) {
			throw new IllegalArgumentException("User does not have the permission to view patient.");
		}
		
		return patientDao.spGetPatientById(id);
	}

}
