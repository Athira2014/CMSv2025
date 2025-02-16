package com.athira.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "consultationnote")
public class ConsultationNote {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ConsNoteId")
    private Integer consNoteId;

    @Lob    // Used for large text fields
    @Column(name = "Symptoms")
    private String symptoms;

    @Lob  // Used for large text fields
    @Column(name = "Diagnosis")
    private String diagnosis;

    @Lob  // Used for large text fields
    @Column(name = "FollowUp")
    private String followUp;
    
    @ManyToOne
    @JoinColumn(name = "AppointmentId", insertable = false, updatable = false)
    private Appointment appointment;  
    
    @Column(name = "AppointmentId", nullable = false)
    private Integer appointmentId;

    @ManyToOne
    @JoinColumn(name = "PatientId", insertable = false, updatable = false)
    private Patient patient;  
    
    @Column(name = "PatientId", nullable = false)
    private Integer patientId;

    public ConsultationNote() {}

	public ConsultationNote(Integer consNoteId, String symptoms, String diagnosis, String followUp, Appointment appointment,
			Patient patient) {
		super();
		this.consNoteId = consNoteId;
		this.symptoms = symptoms;
		this.diagnosis = diagnosis;
		this.followUp = followUp;
		this.appointment = appointment;
		this.patient = patient;
	}

	public Integer getConsNoteId() {
		return consNoteId;
	}

	public void setConsNoteId(Integer consNoteId) {
		this.consNoteId = consNoteId;
	}

	public String getSymptoms() {
		return symptoms;
	}

	public void setSymptoms(String symptoms) {
		this.symptoms = symptoms;
	}

	public String getDiagnosis() {
		return diagnosis;
	}

	public void setDiagnosis(String diagnosis) {
		this.diagnosis = diagnosis;
	}

	public String getFollowUp() {
		return followUp;
	}

	public void setFollowUp(String followUp) {
		this.followUp = followUp;
	}

	public Appointment getAppointment() {
		return appointment;
	}

	public void setAppointment(Appointment appointment) {
		this.appointment = appointment;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public Integer getAppointmentId() {
		return appointmentId;
	}

	public void setAppointmentId(Integer appointmentId) {
		this.appointmentId = appointmentId;
	}

	public Integer getPatientId() {
		return patientId;
	}

	public void setPatientId(Integer patientId) {
		this.patientId = patientId;
	}
   
}
