package com.athira.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Type;
import org.joda.time.DateTime;

@Entity
@Table(name = "labtestresult")
public class LabTestResult {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "LabTestResId", nullable = false)
	private Integer labTestResId;

	@OneToOne
	@JoinColumn(name = "LabTestDetId", insertable = false, updatable = false)
	private LabTestDetails labTestDetails;

	@Column(name = "LabTestDetId", nullable = false)
	private Integer labTestDetId;

	@Column(name = "Description", nullable = false, length = 200)
	private String description;

	@Column(name = "Result", nullable = false)
	private int result;

	@Column(name = "Flag", nullable = false, length = 10)
	private String flag;

	@Column(name = "CreatedDate", nullable = false, length = 10)
	@Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
	private DateTime createdDate;

	@Column(name = "IsActive", nullable = false)
	private boolean isActive;

	public LabTestResult() {
	}

	public LabTestResult(Integer labTestResId, Integer labTestDetId, String description, int result, String flag,
			DateTime createdDate, boolean isActive) {
		super();
		this.labTestResId = labTestResId;
		this.labTestDetId = labTestDetId;
		this.description = description;
		this.result = result;
		this.flag = flag;
		this.createdDate = createdDate;
		this.isActive = isActive;
	}

	public Integer getLabTestResId() {
		return labTestResId;
	}

	public void setLabTestResId(Integer labTestResId) {
		this.labTestResId = labTestResId;
	}

	public LabTestDetails getLabTestDetails() {
		return labTestDetails;
	}

	public void setLabTestDetails(LabTestDetails labTestDetails) {
		this.labTestDetails = labTestDetails;
	}

	public Integer getLabTestDetId() {
		return labTestDetId;
	}

	public void setLabTestDetId(Integer labTestDetId) {
		this.labTestDetId = labTestDetId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getResult() {
		return result;
	}

	public void setResult(int result) {
		this.result = result;
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public DateTime getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(DateTime createdDate) {
		this.createdDate = createdDate;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

}
