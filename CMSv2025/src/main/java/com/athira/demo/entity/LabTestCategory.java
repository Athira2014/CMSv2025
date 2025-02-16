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
@Table(name = "labtestcategory")
public class LabTestCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    @Column(name = "LabTestCatId")
    private Integer labTestCatId;

    @Column(name = "Category", nullable = false, length = 50)
    private String category;

    @Column(name = "IsActive", nullable = false)
    private boolean isActive;

    @Column(name = "CreatedDate", nullable = false)
    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    private DateTime createdDate;
    
    @JsonIgnore
    @OneToMany(mappedBy = "labTestCategory")
    private List<LabTest> labTests;    
    
    // Default constructor
    public LabTestCategory() {
    }

    // Parameterized constructor
    public LabTestCategory(Integer labTestCatId, String category, boolean isActive, DateTime createdDate) {
		super();
		this.labTestCatId = labTestCatId;
		this.category = category;
		this.isActive = isActive;
		this.createdDate = createdDate;
	}

	public Integer getLabTestCatId() {
        return labTestCatId;
    }

   	public void setLabTestCatId(Integer labTestCatId) {
        this.labTestCatId = labTestCatId;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		if (isActive != true && isActive != false) {
	        throw new IllegalArgumentException("Invalid value. Expected true or false.");
	    }
		this.isActive = isActive;
	}

	public DateTime getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(DateTime createdDate) {
		this.createdDate = createdDate;
	}

	public List<LabTest> getLabTests() {
		return labTests;
	}

	public void setLabTests(List<LabTest> labTests) {
		this.labTests = labTests;
	}

}

