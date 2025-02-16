package com.athira.demo.service;

import java.util.List;

import com.athira.demo.entity.Appointment;

public interface IAppointmentService {

	List<Appointment> getAllAppointments();

	Appointment saveAppointment(Appointment appointment, Integer userid, String permission);

}
