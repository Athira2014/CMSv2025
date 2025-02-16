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
@Table(name = "pharmacymedicinescategory")
public class PharmacyMedicineCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-increment primary key
    @Column(name = "PMedCatId")
    private Integer pMedCatId;

    @Column(name = "PMedCatName")
    private String pMedCatName; // Name of the pharmacy medicine category

    @Column(name = "Details")
    private String details; // Description or additional details about the category

    @Column(name = "IsActive")
    private Boolean isActive; // Flag to indicate if the category is active (1 = active, 0 = inactive)

    @Column(name = "CreatedDate")
    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    private DateTime createdDate; // Date when the category was created
    
    @JsonIgnore
    @OneToMany(mappedBy = "pMedCat")
    private List<PharmacyMedicine> pharmacyMedicines;
 
    public PharmacyMedicineCategory() {}

	public PharmacyMedicineCategory(Integer pMedCatId, String pMedCatName, String details, Boolean isActive,
			DateTime createdDate) {
		super();
		this.pMedCatId = pMedCatId;
		this.pMedCatName = pMedCatName;
		this.details = details;
		this.isActive = isActive;
		this.createdDate = createdDate;
	}

	public int getpMedCatId() {
        return pMedCatId;
    }

    public void setpMedCatId(int pMedCatId) {
        this.pMedCatId = pMedCatId;
    }

    public String getpMedCatName() {
        return pMedCatName;
    }

    public void setpMedCatName(String pMedCatName) {
        this.pMedCatName = pMedCatName;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
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

}

