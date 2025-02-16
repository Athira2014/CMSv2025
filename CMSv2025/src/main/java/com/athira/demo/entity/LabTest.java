package com.athira.demo.entity;

import java.sql.Date;
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
@Table(name = "labtest")
public class LabTest {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "LabTestsId")
	private Integer labTestsId;

	@Column(name = "TestName", nullable = false, length = 30)
	private String testName;

	@Column(name = "Description", length = 100)
	private String description;

	@Column(name = "Parameters", length = 100)
	private String parameters;

	@Column(name = "CreatedDate", nullable = false)
	@Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
	private DateTime createdDate;

	@Column(name = "IsActive", nullable = false)
	private Boolean isActive;

	@ManyToOne
	@JoinColumn(name = "LabTestCatId", insertable = false, updatable = false)
	private LabTestCategory labTestCategory; // Relationship with LabTestCategory entity

	@Column(name = "LabTestCatId", nullable = false)
	private Integer labTestCatId;

	/*
	 * @JsonIgnore
	 * 
	 * @OneToMany(mappedBy = "labTest") private List<LabTestPrescription>
	 * labTestPrescriptions;
	 */

	public LabTest() {
	}

	public LabTest(Integer labTestsId, String testName, String description, String parameters, DateTime createdDate,
			Boolean isActive, Integer labTestCatId) {
		super();
		this.labTestsId = labTestsId;
		this.testName = testName;
		this.description = description;
		this.parameters = parameters;
		this.createdDate = createdDate;
		this.isActive = isActive;
		this.labTestCatId = labTestCatId;
	}

	public Integer getLabTestsId() {
		return labTestsId;
	}

	public void setLabTestsId(Integer labTestsId) {
		this.labTestsId = labTestsId;
	}

	public String getTestName() {
		return testName;
	}

	public void setTestName(String testName) {
		this.testName = testName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getParameters() {
		return parameters;
	}

	public void setParameters(String parameters) {
		this.parameters = parameters;
	}

	public DateTime getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(DateTime createdDate) {
		this.createdDate = createdDate;
	}

	public Boolean isActive() {
		return isActive;
	}

	public void setActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public LabTestCategory getLabTestCategory() {
		return labTestCategory;
	}

	public void setLabTestCategory(LabTestCategory labTestCategory) {
		this.labTestCategory = labTestCategory;
	}

	public Integer getLabTestCatId() {
		return labTestCatId;
	}

	public void setLabTestCatId(Integer labTestCatId) {
		this.labTestCatId = labTestCatId;
	}

}
