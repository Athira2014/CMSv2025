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
@Table(name = "medicineprescription")
public class MedicinePrescription {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-increment primary key
    @Column(name = "MedicinePrescId")
    private Integer medicinePrescId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "AppointmentId", insertable = false, updatable = false) 
    private Appointment appointment;
    
    @Column(name = "AppointmentId")
    private Integer appointmentId;// Foreign Key to Appointment

    @Column(name = "Medicines")
    private String medicines; // List or names of medicines prescribed

    @Column(name = "Dosage")
    private Integer dosage; // Dosage prescribed

    @Column(name = "Frequency")
    private String frequency; // Frequency of the dosage

    @Column(name = "createdDate")
	@Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    private DateTime createdDate; // Date the prescription was created
    
    @JsonIgnore
    @OneToMany(mappedBy = "medicinePresc")
    private List<PharmacyPurchase> pharmacyPurchases;

    public MedicinePrescription() {}

	public MedicinePrescription(Integer medicinePrescId, Integer appointmentId, String medicines, Integer dosage,
			String frequency, DateTime createdDate, List<PharmacyPurchase> pharmacyPurchases) {
		super();
		this.medicinePrescId = medicinePrescId;
		this.appointmentId = appointmentId;
		this.medicines = medicines;
		this.dosage = dosage;
		this.frequency = frequency;
		this.createdDate = createdDate;
		this.pharmacyPurchases = pharmacyPurchases;
	}

	public Integer getMedicinePrescId() {
		return medicinePrescId;
	}

	public void setMedicinePrescId(Integer medicinePrescId) {
		this.medicinePrescId = medicinePrescId;
	}

	public Appointment getAppointment() {
		return appointment;
	}

	public void setAppointment(Appointment appointment) {
		this.appointment = appointment;
	}

	public Integer getAppointmentId() {
		return appointmentId;
	}

	public void setAppointmentId(Integer appointmentId) {
		this.appointmentId = appointmentId;
	}

	public String getMedicines() {
		return medicines;
	}

	public void setMedicines(String medicines) {
		this.medicines = medicines;
	}

	public Integer getDosage() {
		return dosage;
	}

	public void setDosage(Integer dosage) {
		this.dosage = dosage;
	}

	public String getFrequency() {
		return frequency;
	}

	public void setFrequency(String frequency) {
		this.frequency = frequency;
	}

	public DateTime getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(DateTime createdDate) {
		this.createdDate = createdDate;
	}

	public List<PharmacyPurchase> getPharmacyPurchases() {
		return pharmacyPurchases;
	}

	public void setPharmacyPurchases(List<PharmacyPurchase> pharmacyPurchases) {
		this.pharmacyPurchases = pharmacyPurchases;
	}

}
