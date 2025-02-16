package com.athira.demo.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.Type;
import org.joda.time.DateTime;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "patient")
public class Patient {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PatientId")
	private Integer patientId;

	@Column(name = "PatientFName", nullable = false, length = 20)
	private String firstName;

	@Column(name = "PatientLName", nullable = false, length = 20)
	private String lastName;

	@Column(name = "DOB", nullable = false)
    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
	private DateTime dob;

	@Column(name = "Sex", nullable = false, length = 1)
	private char sex;

	@Column(name = "Phone", length = 20)
	private String phone;

	@Column(name = "Email", length = 20)
	private String email;

	@Column(name = "Address", length = 50)
	private String address;

	@Column(name = "MembershipStatus", length = 20)
	private String membershipStatus;

	@Column(name = "AlternatePhone", length = 20)
	private String alternatePhone;

	@Column(name = "MemFromDate")
    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
	private DateTime membershipFromDate;
	
	@JsonIgnore
	@OneToMany(mappedBy = "patient")
	private List<Appointment> appointments;
	
	@JsonIgnore
	@OneToMany(mappedBy = "patient")
	private List<ConsultationNote> consultationNotes;

	// Default constructor
	public Patient() {
	}

	public Patient( Integer patientId, String firstName, String lastName, DateTime dob, char sex, String phone, String email,
			String address, String membershipStatus, String alternatePhone, DateTime membershipFromDate) {
		super();
		this.patientId = patientId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dob = dob;
		this.sex = sex;
		this.phone = phone;
		this.email = email;
		this.address = address;
		this.membershipStatus = membershipStatus;
		this.alternatePhone = alternatePhone;
		this.membershipFromDate = membershipFromDate;
	}

	public Integer getPatientId() {
		return patientId;
	}

	public void setPatientId( Integer patientId) {
		this.patientId = patientId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public DateTime getDob() {
		return dob;
	}

	public void setDob(DateTime dob) {
		this.dob = dob;
	}

	public char getSex() {
		return sex;
	}

	public void setSex(char sex) {
		this.sex = sex;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getMembershipStatus() {
		return membershipStatus;
	}

	public void setMembershipStatus(String membershipStatus) {
		this.membershipStatus = membershipStatus;
	}

	public String getAlternatePhone() {
		return alternatePhone;
	}

	public void setAlternatePhone(String alternatePhone) {
		this.alternatePhone = alternatePhone;
	}

	public DateTime getMembershipFromDate() {
		return membershipFromDate;
	}

	public void setMembershipFromDate(DateTime membershipFromDate) {
		this.membershipFromDate = membershipFromDate;
	}

	public List<Appointment> getAppointments() {
		return appointments;
	}

	public void setAppointments(List<Appointment> appointments) {
		this.appointments = appointments;
	}

	public List<ConsultationNote> getConsultationNotes() {
		return consultationNotes;
	}

	public void setConsultationNotes(List<ConsultationNote> consultationNotes) {
		this.consultationNotes = consultationNotes;
	}

}
