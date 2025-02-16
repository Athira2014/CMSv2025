package com.athira.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import org.hibernate.annotations.Type;
import org.joda.time.DateTime;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "labtestdetails")
public class LabTestDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "LabTestDetId")
    private Integer labTestDetId;

    @Column(name = "DateAndTime", nullable = false)
    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    private DateTime dateAndTime;

    @Column(name = "Remarks", length = 100)
    private String remarks;

    @Column(name = "IsActive", nullable = false)
    private Boolean isActive;

    @ManyToOne
    @JoinColumn(name = "LabPrescId", insertable = false, updatable = false)
    private LabTestPrescription labTestPrescription;
    
    @Column(name = "LabPrescId")
    private Integer labPrescId;
    
    @JsonIgnore
    @OneToOne(mappedBy = "labTestDetails")
    private LabTestResult labTestResult;

    public LabTestDetails() {}

	public LabTestDetails(Integer labTestDetId, DateTime dateAndTime, String remarks, Boolean isActive,
			Integer labPrescId) {
		super();
		this.labTestDetId = labTestDetId;
		this.dateAndTime = dateAndTime;
		this.remarks = remarks;
		this.isActive = isActive;
		this.labPrescId = labPrescId;
	}



	public Integer getLabTestDetId() {
		return labTestDetId;
	}

	public void setLabTestDetId(Integer labTestDetId) {
		this.labTestDetId = labTestDetId;
	}

	public DateTime getDateAndTime() {
		return dateAndTime;
	}

	public void setDateAndTime(DateTime dateAndTime) {
		this.dateAndTime = dateAndTime;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public Boolean isActive() {
		return isActive;
	}

	public void setActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public LabTestPrescription getLabTestPrescription() {
		return labTestPrescription;
	}

	public void setLabTestPrescription(LabTestPrescription labTestPrescription) {
		this.labTestPrescription = labTestPrescription;
	}

	public Integer getLabPrescId() {
		return labPrescId;
	}

	public void setLabPrescId(Integer labPrescId) {
		this.labPrescId = labPrescId;
	}

	public LabTestResult getLabTestResult() {
		return labTestResult;
	}

	public void setLabTestResult(LabTestResult labTestResult) {
		this.labTestResult = labTestResult;
	}

}

