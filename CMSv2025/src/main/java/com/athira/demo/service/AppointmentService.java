package com.athira.demo.service;

import java.util.List;
import java.util.concurrent.ExecutorService;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.athira.demo.dao.IAppointmentDao;
import com.athira.demo.entity.Appointment;
import com.athira.demo.entity.Role;

@Transactional
@Service
public class AppointmentService implements IAppointmentService {

	@Autowired
	IAppointmentDao appointmentDao;
	
	@Autowired
	StaffService staffService;

	
	public List<Appointment> getAllAppointments() {
		return appointmentDao.findAll();
	}

	public Appointment saveAppointment(Appointment appointment, Integer userid, String permission) {
		
		Role role = staffService.getUserRoleByUserId(userid);
		boolean hasPermission = staffService.checkIfUserHasPermission(role.getRoleId(), permission);

		// If no permission found, throw an exception
		if (!hasPermission) {
			throw new IllegalArgumentException("User does not have the permission to add appointment.");
		}
		
		return appointmentDao.save(appointment);
	}

}
