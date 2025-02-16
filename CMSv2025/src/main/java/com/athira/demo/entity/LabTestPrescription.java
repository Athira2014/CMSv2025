package com.athira.demo.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Type;
import org.joda.time.DateTime;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "labtestprescription")
public class LabTestPrescription {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-increment primary key
    @Column(name = "LabPrescId")
    private Integer labPrescId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "AppointmentId",insertable = false, updatable = false)
    private Appointment appointment; 

    @Column(name = "AppointmentId")
    private Integer appointmentId; // Foreign Key to Appointment
    
    /*
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "LabTestsId", insertable = false, updatable = false)
    private LabTest labTest; 
    
        @Column(name = "LabTestsId") // Foreign Key to Appointment
    private Integer labTestsId;
    */
    
    @ManyToMany
    @JoinTable(
        name = "labtest_labtestprescription", 
        joinColumns = @JoinColumn(name = "lab_presc_id"),
        inverseJoinColumns = @JoinColumn(name = "lab_tests_id")
    )
    private List<LabTest> labTests; // A prescription can have multiple lab tests
    


    @Column(name = "TestToBeDoneOnOrBefore")
    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    private DateTime testToBeDoneOnOrBefore;

    @Column(name = "IsActive")
    private boolean isActive; // Will map to a tinyint(1) (boolean in Java)

    @Column(name = "CreatedDate")
    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    private DateTime createdDate;
    
    @JsonIgnore
    @OneToMany(mappedBy = "labTestPrescription")
    private List<LabTestDetails> labTestDetails;
    
    public LabTestPrescription() {}

	public LabTestPrescription(Integer labPrescId, Integer appointmentId,
			DateTime testToBeDoneOnOrBefore, boolean isActive, DateTime createdDate) {
		super();
		this.labPrescId = labPrescId;
		this.appointmentId = appointmentId;
		//this.labTestsId = labTestsId;
		this.testToBeDoneOnOrBefore = testToBeDoneOnOrBefore;
		this.isActive = isActive;
		this.createdDate = createdDate;
	}

	public Integer getLabPrescId() {
		return labPrescId;
	}

	public void setLabPrescId(Integer labPrescId) {
		this.labPrescId = labPrescId;
	}

	public Appointment getAppointment() {
		return appointment;
	}

	public void setAppointment(Appointment appointment) {
		this.appointment = appointment;
	}

//	public LabTest getLabTest() {
//		return labTest;
//	}
//
//	public void setLabTest(LabTest labTest) {
//		this.labTest = labTest;
//	}

	public DateTime getTestToBeDoneOnOrBefore() {
		return testToBeDoneOnOrBefore;
	}

	public void setTestToBeDoneOnOrBefore(DateTime testToBeDoneOnOrBefore) {
		this.testToBeDoneOnOrBefore = testToBeDoneOnOrBefore;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public DateTime getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(DateTime createdDate) {
		this.createdDate = createdDate;
	}

	public Integer getAppointmentId() {
		return appointmentId;
	}

	public void setAppointmentId(Integer appointmentId) {
		this.appointmentId = appointmentId;
	}

	public List<LabTestDetails> getLabTestDetails() {
		return labTestDetails;
	}

	public void setLabTestDetails(List<LabTestDetails> labTestDetails) {
		this.labTestDetails = labTestDetails;
	}

	public List<LabTest> getLabTests() {
		return labTests;
	}

	public void setLabTests(List<LabTest> labTests) {
		this.labTests = labTests;
	}

}

