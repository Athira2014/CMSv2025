package com.athira.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Type;
import org.joda.time.DateTime;

@Entity
@Table(name = "qualification")
public class Qualification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-increment primary key
    @Column(name = "QId")
    private Integer qId;

    @Column(name = "Qualification")
    private String qualification; // The qualification (e.g., degree, certification)

    @Column(name = "QualifiedOn")
    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    private DateTime qualifiedOn; // The date when the qualification was obtained

    @Column(name = "CreatedDate")
    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    private DateTime createdDate; // The date when the record was created

    @Column(name = "IsActive")
    private boolean isActive; 

    // Default constructor
    public Qualification() {}

    // Constructor with parameters

	public Qualification(Integer qId, String qualification, DateTime qualifiedOn, DateTime createdDate, boolean isActive) {
		super();
		this.qId = qId;
		this.qualification = qualification;
		this.qualifiedOn = qualifiedOn;
		this.createdDate = createdDate;
		this.isActive = isActive;
	}
    // Getters and setters
    public Integer getqId() {
        return qId;
    }

	public void setqId(Integer qId) {
        this.qId = qId;
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public DateTime getQualifiedOn() {
        return qualifiedOn;
    }

    public void setQualifiedOn(DateTime qualifiedOn) {
        this.qualifiedOn = qualifiedOn;
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
