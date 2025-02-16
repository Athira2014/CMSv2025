package com.athira.demo.entity;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

@Entity
@Table(name = "pharmacypurchase")
public class PharmacyPurchase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-increment primary key
    @Column(name = "PPurchaseId")
    private Integer pPurchaseId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MedicinePrescId", insertable = false, updatable = false) // Foreign Key to MedicinePrescription
    private MedicinePrescription medicinePresc;
    
    @Column(name = "MedicinePrescId")
    private Integer medicinePrescId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PMedInvId", insertable = false, updatable = false) // Foreign Key to PharmacyMedicinesInventory
    private PharmacyMedicineInventory pMedInv; // Reference to PharmacyMedicinesInventory entity
    
    @Column(name = "PMedInvId")
    private Integer pMedInvId;

    @Column(name = "PricePerUnit")
    private BigDecimal pricePerUnit; // Price per unit of the medicine

    @Column(name = "Dosage")
    private Integer dosage; // Dosage of the medicine purchased

    @Column(name = "TotalPrice")
    private BigDecimal totalPrice; // Total price for the purchase (PricePerUnit * Dosage)

    @Column(name = "IsActive")
    private boolean isActive; // Flag to indicate if the purchase record is active

    @Column(name = "CreatedDate")
    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    private Date createdDate;
    
    public PharmacyPurchase() {}

	public PharmacyPurchase(Integer pPurchaseId, Integer medicinePrescId, Integer pMedInvId, BigDecimal pricePerUnit,
			Integer dosage, BigDecimal totalPrice, boolean isActive, Date createdDate) {
		super();
		this.pPurchaseId = pPurchaseId;
		this.medicinePrescId = medicinePrescId;
		this.pMedInvId = pMedInvId;
		this.pricePerUnit = pricePerUnit;
		this.dosage = dosage;
		this.totalPrice = totalPrice;
		this.isActive = isActive;
		this.createdDate = createdDate;
	}

	public Integer getpPurchaseId() {
		return pPurchaseId;
	}

	public void setpPurchaseId(Integer pPurchaseId) {
		this.pPurchaseId = pPurchaseId;
	}

	public MedicinePrescription getMedicinePresc() {
		return medicinePresc;
	}

	public void setMedicinePresc(MedicinePrescription medicinePresc) {
		this.medicinePresc = medicinePresc;
	}

	public Integer getMedicinePrescId() {
		return medicinePrescId;
	}

	public void setMedicinePrescId(Integer medicinePrescId) {
		this.medicinePrescId = medicinePrescId;
	}

	public PharmacyMedicineInventory getpMedInv() {
		return pMedInv;
	}

	public void setpMedInv(PharmacyMedicineInventory pMedInv) {
		this.pMedInv = pMedInv;
	}

	public Integer getpMedInvId() {
		return pMedInvId;
	}

	public void setpMedInvId(Integer pMedInvId) {
		this.pMedInvId = pMedInvId;
	}

	public BigDecimal getPricePerUnit() {
		return pricePerUnit;
	}

	public void setPricePerUnit(BigDecimal pricePerUnit) {
		this.pricePerUnit = pricePerUnit;
	}

	public Integer getDosage() {
		return dosage;
	}

	public void setDosage(Integer dosage) {
		this.dosage = dosage;
	}

	public BigDecimal getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(BigDecimal totalPrice) {
		this.totalPrice = totalPrice;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

}
