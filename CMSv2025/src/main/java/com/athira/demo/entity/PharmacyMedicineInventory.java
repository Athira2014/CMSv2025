package com.athira.demo.entity;

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
import org.joda.time.DateTime;

@Entity
@Table(name = "pharmacymedicinesinventory")
public class PharmacyMedicineInventory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-increment primary key
    @Column(name = "PMedInvId")
    private Integer pMedInvId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PMedId", insertable = false, updatable = false) 
    private PharmacyMedicine pMed; // Reference to PharmacyMedicine entity
    
    @Column(name = "PMedId")
    private Integer pMedId;// Foreign Key to PharmacyMedicine

    @Column(name = "ExpiryDate")
    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    private DateTime expiryDate; // Expiry date of the medicine

    @Column(name = "Manufacturer")
    private String manufacturer; // Manufacturer of the medicine

    @Column(name = "Count")
    private int count; // Available count of the medicine in the inventory

    @Column(name = "LowFlag")
    private char lowFlag; // Flag to indicate if the stock is low ('Y' or 'N')

    @Column(name = "IsActive")
    private Boolean isActive; // Flag to indicate if the inventory record is active

    @Column(name = "CreatedDate")
    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    private DateTime createdDate;
    
    public PharmacyMedicineInventory() {}

	public PharmacyMedicineInventory(Integer pMedInvId, PharmacyMedicine pMed, DateTime expiryDate, String manufacturer,
			int count, char lowFlag, Boolean isActive, DateTime createdDate) {
		super();
		this.pMedInvId = pMedInvId;
		this.pMed = pMed;
		this.expiryDate = expiryDate;
		this.manufacturer = manufacturer;
		this.count = count;
		this.lowFlag = lowFlag;
		this.isActive = isActive;
		this.createdDate = createdDate;
	}

	public Integer getpMedInvId() {
		return pMedInvId;
	}

	public void setpMedInvId(Integer pMedInvId) {
		this.pMedInvId = pMedInvId;
	}

	public PharmacyMedicine getpMed() {
		return pMed;
	}

	public void setpMed(PharmacyMedicine pMed) {
		this.pMed = pMed;
	}

	public DateTime getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(DateTime expiryDate) {
		this.expiryDate = expiryDate;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public char getLowFlag() {
		return lowFlag;
	}

	public void setLowFlag(char lowFlag) {
		this.lowFlag = lowFlag;
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

	public Integer getpMedId() {
		return pMedId;
	}

	public void setpMedId(Integer pMedId) {
		this.pMedId = pMedId;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

}
