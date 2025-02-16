package com.athira.demo.service;

import java.util.List;

import com.athira.demo.entity.LabTestDetails;
import com.athira.demo.entity.MedicinePrescription;
import com.athira.demo.entity.PharmacyMedicine;
import com.athira.demo.entity.PharmacyMedicineCategory;
import com.athira.demo.entity.PharmacyMedicineInventory;
import com.athira.demo.entity.PharmacyPurchase;

public interface IPharmacyMedicineService {

	List<PharmacyMedicine> getAllMedicines();

	List<PharmacyMedicineCategory> getAllPharmacyMedicineCategories();

	List<PharmacyMedicineInventory> getAllPharmacyMedicineInventories();

	List<PharmacyPurchase> getAllPharmacyPurchases();

	PharmacyMedicineInventory addToMedicinesInventory(PharmacyMedicineInventory phMedicineInventory);

	PharmacyMedicine addMedicines(PharmacyMedicine pharmacyMedicine);

	PharmacyMedicineCategory addPharmacyMedicineCategory(PharmacyMedicineCategory phMedCategory);

	PharmacyMedicine updateMedicines(PharmacyMedicine pharmacyMedicine);

	PharmacyMedicineCategory updatePharmacyMedicineCategory(PharmacyMedicineCategory phMedCategory);

	PharmacyMedicineInventory updateMedicinesInventory(PharmacyMedicineInventory phMedicineInventory);

	PharmacyPurchase savePharmacyPurchases(PharmacyPurchase phPurchase);

	void disableMedicines(Integer id);

	void disablePharmacyMedicineCategories(Integer id);

	void disablePharmacyMedicineInventories(Integer id);

	void disablePharmacyPurchases(Integer id);

	List<MedicinePrescription> getMedicinePrescriptionByAppointmentId(Integer appointmentId);

	List<MedicinePrescription> getMedicinePrescriptionById(Integer id);

}
