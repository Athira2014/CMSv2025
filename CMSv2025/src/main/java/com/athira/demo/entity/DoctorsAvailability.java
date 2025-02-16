 package com.athira.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.hibernate.annotations.Type;
import org.joda.time.DateTime;

@Entity
@Table(name = "doctorsavailability")
public class DoctorsAvailability {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "DocAvailabilitytId")
    private Integer docAvailabilitytId;

    @Column(name = "AppointmentDate", nullable = false)
    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    private DateTime appointmentDate;

    @Column(name = "AppointmentFrom", nullable = false)
    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    private DateTime appointmentFrom;

    @Column(name = "AppointmentTo", nullable = false)
    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    private DateTime appointmentTo;

    //"AVAILABLE,NOTAVAILABLE"
    @Column(name = "AvailabilityStatus", nullable = false, length = 20)
    private String availabilityStatus;

    @Column(name = "CreatedDate", nullable = false)
    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    private DateTime createdDate;

    @ManyToOne
    @JoinColumn(name = "DocId", insertable = false, updatable = false)
    private Doctor doctor;  // Relationship with Doctor entity
    
    @Column(name = "DocId", nullable = false)
    private Integer docId;
    
    @ManyToOne
    @JoinColumn(name = "AppointmentId", nullable = true)
    private Appointment appointment;
    
    @Column(name = "AppointmentId", insertable = false, updatable = false)
    private Integer appointmentId;

    public DoctorsAvailability() {}

	public DoctorsAvailability(Integer docAvailabilitytId, DateTime appointmentDate, DateTime appointmentFrom,
			DateTime appointmentTo, String availabilityStatus, DateTime createdDate, Integer docId,
			Integer appointmentId) {
		super();
		this.docAvailabilitytId = docAvailabilitytId;
		this.appointmentDate = appointmentDate;
		this.appointmentFrom = appointmentFrom;
		this.appointmentTo = appointmentTo;
		this.availabilityStatus = availabilityStatus;
		this.createdDate = createdDate;
		this.docId = docId;
		this.appointmentId = appointmentId;
	}

	public Integer getDocAvailabilitytId() {
		return docAvailabilitytId;
	}

	public void setDocAvailabilitytId(Integer docAvailabilitytId) {
		this.docAvailabilitytId = docAvailabilitytId;
	}

	public DateTime getAppointmentDate() {
		return appointmentDate;
	}

	public void setAppointmentDate(DateTime appointmentDate) {
		this.appointmentDate = appointmentDate;
	}

	public DateTime getAppointmentFrom() {
		return appointmentFrom;
	}

	public void setAppointmentFrom(DateTime appointmentFrom) {
		this.appointmentFrom = appointmentFrom;
	}

	public DateTime getAppointmentTo() {
		return appointmentTo;
	}

	public void setAppointmentTo(DateTime appointmentTo) {
		this.appointmentTo = appointmentTo;
	}

	public String getAvailabilityStatus() {
		return availabilityStatus;
	}

	public void setAvailabilityStatus(String availabilityStatus) {
		
		if(availabilityStatus == null || availabilityStatus.trim().isEmpty()) {
			throw new IllegalArgumentException("Availability Status should not be empty or null.");
		} 
		// Convert the input to upper case and check if it's either "AVAILABLE" or "NOTAVAILABLE"
	    availabilityStatus = availabilityStatus.trim().toUpperCase();
	    
	    if (!"AVAILABLE".equals(availabilityStatus) && !"NOTAVAILABLE".equals(availabilityStatus)) {
	        throw new IllegalArgumentException("Availability Status should be either AVAILABLE or NOTAVAILABLE.");
	    }
		this.availabilityStatus = availabilityStatus;
	}

	public DateTime getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(DateTime createdDate) {
		this.createdDate = createdDate;
	}

	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	public Appointment getAppointment() {
		return appointment;
	}

	public void setAppointment(Appointment appointment) {
		this.appointment = appointment;
	}

	public Integer getDocId() {
		return docId;
	}

	public void setDocId(Integer docId) {
		this.docId = docId;
	}

	public Integer getAppointmentId() {
		return appointmentId;
	}

	public void setAppointmentId(Integer appointmentId) {
		this.appointmentId = appointmentId;
	}

	
}
