package com.athira.demo.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
@Table(name = "pharmacymedicine")
public class PharmacyMedicine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-increment primary key
    @Column(name = "PMedId")
    private Integer pMedId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PMedCatId", insertable = false, updatable = false) 
    private PharmacyMedicineCategory pMedCat; 
    
    @Column(name = "PMedCatId")// Foreign Key to PharmacyMedicinesCategory
    private Integer pMedCatId;

    @Column(name = "Name")
    private String name; // Name of the medicine

    @Column(name = "Details")
    private String details; // Description or additional details about the medicine

    @Column(name = "IsActive")
    private Boolean isActive; // Flag to indicate if the medicine is active (1 = active, 0 = inactive)

    @Column(name = "CreatedDate")
    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    private DateTime createdDate; // Date when the medicine record was created
    
    @JsonIgnore
    @OneToMany(mappedBy = "pMed")
    private List<PharmacyMedicineInventory> PharmacyMedicineInventories;
    
    public PharmacyMedicine() {}

	public PharmacyMedicine(int pMedId, PharmacyMedicineCategory pMedCat, String name, String details, Boolean isActive,
			DateTime createdDate, List<PharmacyMedicineInventory> pharmacyMedicineInventories) {
		super();
		this.pMedId = pMedId;
		this.pMedCat = pMedCat;
		this.name = name;
		this.details = details;
		this.isActive = isActive;
		this.createdDate = createdDate;
		PharmacyMedicineInventories = pharmacyMedicineInventories;
	}

	public PharmacyMedicineCategory getpMedCat() {
		return pMedCat;
	}

	public void setpMedCat(PharmacyMedicineCategory pMedCat) {
		this.pMedCat = pMedCat;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public Boolean isActive() {
		return isActive;
	}

	public void setActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public DateTime getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(DateTime createdDate) {
		this.createdDate = createdDate;
	}

	public Integer getpMedCatId() {
		return pMedCatId;
	}

	public void setpMedCatId(Integer pMedCatId) {
		this.pMedCatId = pMedCatId;
	}

	public List<PharmacyMedicineInventory> getPharmacyMedicineInventories() {
		return PharmacyMedicineInventories;
	}

	public void setPharmacyMedicineInventories(List<PharmacyMedicineInventory> pharmacyMedicineInventories) {
		PharmacyMedicineInventories = pharmacyMedicineInventories;
	}

	public void setpMedId(Integer pMedId) {
		this.pMedId = pMedId;
	}

	public Integer getpMedId() {
		return pMedId;
	}

}
