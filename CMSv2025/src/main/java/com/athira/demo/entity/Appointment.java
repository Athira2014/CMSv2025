package com.athira.demo.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Type;
import org.joda.time.DateTime;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "appointment")
public class Appointment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "AppointmentId")
	private Integer appointmentId;

    @Column(name = "AppointmentDate", nullable = false)
    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    private DateTime appointmentDate;

    @Column(name = "ReasonForVisist", nullable = false, length = 200)
    private String reasonForVisit;

    @Column(name = "ScheduleStatus", nullable = false, length = 20)
    private String scheduleStatus;

    @Column(name = "CreatedDate", nullable = false)
    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    private DateTime createdDate;

    @Column(name = "UpdatedDate", nullable = true)
    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    private DateTime updatedDate;

    @Column(name = "AppointmentTime", nullable = false)
    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    private DateTime appointmentTime;

    @Column(name = "isActive", nullable = false)
    private boolean isActive;
    
	// Relationship with Doctor class
    @ManyToOne
    @JoinColumn(name = "DocId", insertable = false, updatable = false)
	private Doctor doctor;

    @Column(name = "DocId", nullable = false)
	private Integer docId;
	
	// Relationship with patient class
    @ManyToOne
    @JoinColumn(name="PatientId",  insertable = false, updatable = false)
	private Patient patient;
    
    @Column(name = "PatientId", nullable = false)
	private Integer patientId;
    
    @JsonIgnore
    @OneToMany(mappedBy = "appointment")
    private List<ConsultationBilling> consultationBillingList;
    
    @JsonIgnore
    @OneToMany(mappedBy = "appointment")
    private List<ConsultationNote> consultationNotes;
    
    @JsonIgnore
    @OneToMany(mappedBy = "appointment")
    private List<DoctorsAvailability> doctorsAvailabilities;
    
    @JsonIgnore
    @OneToMany(mappedBy = "appointment")
    private List<LabTestPrescription> labTestPrescriptions;
    
    @JsonIgnore
    @OneToMany(mappedBy = "appointment")
    private List<MedicinePrescription> medicinePrescriptions;

	public Appointment() {
	}

	public Appointment(Integer appointmentId, DateTime appointmentDate, String reasonForVisit, String scheduleStatus,
			DateTime createdDate, DateTime updatedDate, DateTime appointmentTime, boolean isActive, Doctor doctor,
			Patient patient) {
		super();
		this.appointmentId = appointmentId;
		this.appointmentDate = appointmentDate;
		this.reasonForVisit = reasonForVisit;
		this.scheduleStatus = scheduleStatus;
		this.createdDate = createdDate;
		this.updatedDate = updatedDate;
		this.appointmentTime = appointmentTime;
		this.isActive = isActive;
		this.doctor = doctor;
		this.patient = patient;
	}

	public Integer getAppointmentId() {
		return appointmentId;
	}

	public void setAppointmentId(Integer appointmentId) {
		this.appointmentId = appointmentId;
	}

	public DateTime getAppointmentDate() {
		return appointmentDate;
	}

	public void setAppointmentDate(DateTime appointmentDate) {
		this.appointmentDate = appointmentDate;
	}

	public String getReasonForVisit() {
		return reasonForVisit;
	}

	public void setReasonForVisit(String reasonForVisit) {
		this.reasonForVisit = reasonForVisit;
	}

	public String getScheduleStatus() {
		return scheduleStatus;
	}

	public void setScheduleStatus(String scheduleStatus) {
		this.scheduleStatus = scheduleStatus;
	}

	public DateTime getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(DateTime createdDate) {
		this.createdDate = createdDate;
	}

	public DateTime getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(DateTime updatedDate) {
		this.updatedDate = updatedDate;
	}

	public DateTime getAppointmentTime() {
		return appointmentTime;
	}

	public void setAppointmentTime(DateTime appointmentTime) {
		this.appointmentTime = appointmentTime;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public Integer getDocId() {
		return docId;
	}

	public void setDocId(Integer docId) {
		this.docId = docId;
	}

	public Integer getPatientId() {
		return patientId;
	}

	public void setPatientId(Integer patientId) {
		this.patientId = patientId;
	}

	public List<ConsultationBilling> getConsultationBillingList() {
		return consultationBillingList;
	}

	public void setConsultationBillingList(List<ConsultationBilling> consultationBillingList) {
		this.consultationBillingList = consultationBillingList;
	}

	public List<ConsultationNote> getConsultationNotes() {
		return consultationNotes;
	}

	public void setConsultationNotes(List<ConsultationNote> consultationNotes) {
		this.consultationNotes = consultationNotes;
	}

	public List<DoctorsAvailability> getDoctorsAvailabilities() {
		return doctorsAvailabilities;
	}

	public void setDoctorsAvailabilities(List<DoctorsAvailability> doctorsAvailabilities) {
		this.doctorsAvailabilities = doctorsAvailabilities;
	}

	public List<LabTestPrescription> getLabTestPrescriptions() {
		return labTestPrescriptions;
	}

	public void setLabTestPrescriptions(List<LabTestPrescription> labTestPrescriptions) {
		this.labTestPrescriptions = labTestPrescriptions;
	}

	public List<MedicinePrescription> getMedicinePrescriptions() {
		return medicinePrescriptions;
	}

	public void setMedicinePrescriptions(List<MedicinePrescription> medicinePrescriptions) {
		this.medicinePrescriptions = medicinePrescriptions;
	}

}
