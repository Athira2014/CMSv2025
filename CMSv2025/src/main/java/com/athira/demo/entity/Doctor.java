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
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Type;
import org.joda.time.DateTime;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "doctor")
public class Doctor {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    @Column(name = "DocId")
    private Integer docId;
    
    //Relationship with staff class
    @OneToOne()
    @JoinColumn(name = "StaffId", insertable = false, updatable = false)
    private Staff staff;
    
    @Column(name = "StaffId", nullable = false)
    private Integer staffId;
    
    //Relationship with Specialization class
    @ManyToOne
    @JoinColumn(name = "SpecializationId", insertable = false, updatable = false)
    private Specialization specialization;
    
    @Column(name = "SpecializationId", nullable = false)
	private Integer specializationId;
    
    @Column(name = "Fee", nullable = false, precision = 5, scale = 2)
    private double fee;

    @Column(name = "LicenceNo", nullable = false, length = 25)
    private String licenceNo;

    @Column(name = "CreatedDate", nullable = false)
    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    private DateTime createdDate;
    
    @JsonIgnore
    @OneToMany(mappedBy = "doctor")
    private List<Appointment> appintments;
    
    @JsonIgnore
    @OneToMany(mappedBy = "doctor")
    private List<DoctorsAvailability> doctorsAvailabilities;
    
    @Column(name = "isActive", nullable = false)
    private boolean isActive;

    // Default constructor
    public Doctor() {}

	public Doctor(Integer docId, Staff staff, Specialization specialization, double fee, String licenceNo,
			DateTime createdDate) {
		super();
		this.docId = docId;
		this.staff = staff;
		this.specialization = specialization;
		this.fee = fee;
		this.licenceNo = licenceNo;
		this.createdDate = createdDate;
	}

	public Integer getDocId() {
		return docId;
	}

	public void setDocId(Integer docId) {
		this.docId = docId;
	}

	public Staff getStaff() {
		return staff;
	}

	public void setStaff(Staff staff) {
		this.staff = staff;
	}

	public Specialization getSpecialization() {
		return specialization;
	}

	public void setSpecialization(Specialization specialization) {
		this.specialization = specialization;
	}

	public double getFee() {
		return fee;
	}

	public void setFee(double fee) {
		this.fee = fee;
	}

	public String getLicenceNo() {
		return licenceNo;
	}

	public void setLicenceNo(String licenceNo) {
		this.licenceNo = licenceNo;
	}

	public DateTime getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(DateTime createdDate) {
		this.createdDate = createdDate;
	}

	public Integer getStaffId() {
		return staffId;
	}

	public void setStaffId(Integer staffId) {
		if(staffId == null || staffId == 0) {
			throw new IllegalArgumentException("Staff Id cannot be null.");
		}
		this.staffId = staffId;
	}

	public Integer getSpecializationId() {
		return specializationId;
	}

	public void setSpecializationId(Integer specializationId) {
		if(specializationId == null || specializationId == 0) {
			throw new IllegalArgumentException("Specialization Id cannot be null.");
		}
		this.specializationId = specializationId;
	}

	public List<Appointment> getAppintments() {
		return appintments;
	}

	public void setAppintments(List<Appointment> appintments) {
		this.appintments = appintments;
	}

	public List<DoctorsAvailability> getDoctorsAvailabilities() {
		return doctorsAvailabilities;
	}

	public void setDoctorsAvailabilities(List<DoctorsAvailability> doctorsAvailabilities) {
		this.doctorsAvailabilities = doctorsAvailabilities;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

}
