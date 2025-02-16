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
@Table(name = "specialization")
public class Specialization {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SpecializationId")
    private Integer specializationId;

    @Column(name = "SpecializationName", nullable = false, length = 25)
    private String specializationName;

    @Column(name = "CreatedDate", nullable = false)
    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    private DateTime createdDate;

    @Column(name = "IsActive", nullable = false)
    private boolean isActive;
    
    @JsonIgnore
    @OneToMany(mappedBy = "specialization")
    private List<Doctor> doctors;

	// Default constructor
	public Specialization() {
		
	}

	// parameterized constructor

	public Specialization(Integer specializationId, String specializationName, boolean isActive, DateTime createdDate) {
		super();
		this.specializationId = specializationId;
		this.specializationName = specializationName;
		this.isActive = isActive;
		this.createdDate = createdDate;
	}


	public Integer getSpecializationId() {
		return specializationId;
	}

	public void setSpecializationId(Integer specializationId) {
		this.specializationId = specializationId;
	}

	public String getSpecializationName() {
		return specializationName;
	}

	public void setSpecializationName(String specializationName) {
		if(specializationName == null || specializationName.trim().isEmpty()) {
			throw new IllegalArgumentException("Specialization name cannot be empty or null.");
		}
		this.specializationName = specializationName;
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
	
}
