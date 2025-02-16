package com.athira.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.athira.demo.common.APIResponse;
import com.athira.demo.entity.LabTestDetails;
import com.athira.demo.entity.MedicinePrescription;
import com.athira.demo.entity.PharmacyMedicine;
import com.athira.demo.entity.PharmacyMedicineCategory;
import com.athira.demo.entity.PharmacyMedicineInventory;
import com.athira.demo.entity.PharmacyPurchase;
import com.athira.demo.service.IPharmacyMedicineService;

@RestController
@RequestMapping("api/")
public class PharmacyController {

	@Autowired
	IPharmacyMedicineService pharmacyMedicineService;

	@GetMapping("medicines")
	public List<PharmacyMedicine> getAllMedicines() {
		return pharmacyMedicineService.getAllMedicines();
	}

	@GetMapping("medicinesCategories")
	public List<PharmacyMedicineCategory> getAllPharmacyMedicineCategories() {
		return pharmacyMedicineService.getAllPharmacyMedicineCategories();
	}

	@GetMapping("medicineInventories")
	public List<PharmacyMedicineInventory> getAllPharmacyMedicineInventories() {
		return pharmacyMedicineService.getAllPharmacyMedicineInventories();
	}

	@GetMapping("pharmacyPurchases")
	public List<PharmacyPurchase> getAllPharmacyPurchases() {
		return pharmacyMedicineService.getAllPharmacyPurchases();
	}

	// ADD new medicine
	@PostMapping("medicines")
	private ResponseEntity<APIResponse> addMedicines(@RequestBody PharmacyMedicine pharmacyMedicine) {

		APIResponse apiResponse = new APIResponse();

		try {
			PharmacyMedicine pharmacyMedicineEntity = pharmacyMedicineService.addMedicines(pharmacyMedicine);
			apiResponse.setStatus(200);
			apiResponse.setData(pharmacyMedicineEntity);

		} catch (Exception e) {
			apiResponse.setStatus(500);
			apiResponse.setError(e.getMessage());
		}
		return ResponseEntity.status(apiResponse.getStatus()).body(apiResponse);
	}

	// ADD medicine data to inventory
	@PostMapping("medicineInventories")
	private ResponseEntity<APIResponse> addToMedicinesInventory(
			@RequestBody PharmacyMedicineInventory phMedicineInventory) {

		APIResponse apiResponse = new APIResponse();

		try {
			PharmacyMedicineInventory phMedInventoryEntity = pharmacyMedicineService
					.addToMedicinesInventory(phMedicineInventory);
			apiResponse.setStatus(200);
			apiResponse.setData(phMedInventoryEntity);

		} catch (Exception e) {
			apiResponse.setStatus(500);
			apiResponse.setError(e.getMessage());
		}
		return ResponseEntity.status(apiResponse.getStatus()).body(apiResponse);
	}

	// ADD medicine category
	@PostMapping("medicinesCategories")
	private ResponseEntity<APIResponse> addPharmacyMedicineCategory(
			@RequestBody PharmacyMedicineCategory phMedCategory) {

		APIResponse apiResponse = new APIResponse();

		try {
			PharmacyMedicineCategory phMedCategoryEntity = pharmacyMedicineService
					.addPharmacyMedicineCategory(phMedCategory);
			apiResponse.setStatus(200);
			apiResponse.setData(phMedCategoryEntity);

		} catch (Exception e) {
			apiResponse.setStatus(500);
			apiResponse.setError(e.getMessage());
		}
		return ResponseEntity.status(apiResponse.getStatus()).body(apiResponse);
	}

	// Update medicine
	@PutMapping("medicines")
	private ResponseEntity<APIResponse> updateMedicines(@RequestBody PharmacyMedicine pharmacyMedicine) {

		APIResponse apiResponse = new APIResponse();

		try {
			PharmacyMedicine pharmacyMedicineEntity = pharmacyMedicineService.updateMedicines(pharmacyMedicine);
			apiResponse.setStatus(200);
			apiResponse.setData(pharmacyMedicineEntity);

		} catch (Exception e) {
			apiResponse.setStatus(500);
			apiResponse.setError(e.getMessage());
		}
		return ResponseEntity.status(apiResponse.getStatus()).body(apiResponse);
	}

	// Update medicine category
	@PutMapping("medicinesCategories")
	private ResponseEntity<APIResponse> updatePharmacyMedicineCategory(
			@RequestBody PharmacyMedicineCategory phMedCategory) {

		APIResponse apiResponse = new APIResponse();

		try {
			PharmacyMedicineCategory phMedCategoryEntity = pharmacyMedicineService
					.updatePharmacyMedicineCategory(phMedCategory);
			apiResponse.setStatus(200);
			apiResponse.setData(phMedCategoryEntity);

		} catch (Exception e) {
			apiResponse.setStatus(500);
			apiResponse.setError(e.getMessage());
		}
		return ResponseEntity.status(apiResponse.getStatus()).body(apiResponse);
	}

	// Update medicine data to inventory
	@PutMapping("medicineInventories")
	private ResponseEntity<APIResponse> updateMedicinesInventory(
			@RequestBody PharmacyMedicineInventory phMedicineInventory) {

		APIResponse apiResponse = new APIResponse();

		try {
			PharmacyMedicineInventory phMedInventoryEntity = pharmacyMedicineService
					.updateMedicinesInventory(phMedicineInventory);
			apiResponse.setStatus(200);
			apiResponse.setData(phMedInventoryEntity);

		} catch (Exception e) {
			apiResponse.setStatus(500);
			apiResponse.setError(e.getMessage());
		}
		return ResponseEntity.status(apiResponse.getStatus()).body(apiResponse);
	}

	@PostMapping("pharmacyPurchases")
	public ResponseEntity<APIResponse> addPharmacyPurchases(@RequestBody PharmacyPurchase phPurchase) {

		APIResponse apiResponse = new APIResponse();

		try {
			PharmacyPurchase phPurchaseEntity = pharmacyMedicineService.savePharmacyPurchases(phPurchase);
			apiResponse.setStatus(200);
			apiResponse.setData(phPurchaseEntity);

		} catch (Exception e) {
			apiResponse.setStatus(500);
			apiResponse.setError(e.getMessage());
		}
		return ResponseEntity.status(apiResponse.getStatus()).body(apiResponse);
	}

	@PutMapping("pharmacyPurchases")
	public ResponseEntity<APIResponse> updatePharmacyPurchases(@RequestBody PharmacyPurchase phPurchase) {

		APIResponse apiResponse = new APIResponse();

		try {
			PharmacyPurchase phPurchaseEntity = pharmacyMedicineService.savePharmacyPurchases(phPurchase);
			apiResponse.setStatus(200);
			apiResponse.setData(phPurchaseEntity);

		} catch (Exception e) {
			apiResponse.setStatus(500);
			apiResponse.setError(e.getMessage());
		}
		return ResponseEntity.status(apiResponse.getStatus()).body(apiResponse);
	}

	@DeleteMapping("medicines/{id}")
	public ResponseEntity<APIResponse> disableMedicines(@PathVariable Integer id) {
		APIResponse apiResponse = new APIResponse();

		try {
			pharmacyMedicineService.disableMedicines(id);
			apiResponse.setStatus(200);
			apiResponse.setData("Medicine disabled succesfully");

		} catch (Exception e) {
			apiResponse.setStatus(500);
			apiResponse.setError(e.getMessage());
		}
		return ResponseEntity.status(apiResponse.getStatus()).body(apiResponse);
	}

	@DeleteMapping("medicinesCategories/{id}")
	public ResponseEntity<APIResponse> disablePharmacyMedicineCategories(@PathVariable Integer id) {
		APIResponse apiResponse = new APIResponse();

		try {
			pharmacyMedicineService.disablePharmacyMedicineCategories(id);
			apiResponse.setStatus(200);
			apiResponse.setData("Medicine disabled succesfully");

		} catch (Exception e) {
			apiResponse.setStatus(500);
			apiResponse.setError(e.getMessage());
		}
		return ResponseEntity.status(apiResponse.getStatus()).body(apiResponse);
	}

	@DeleteMapping("medicineInventories/{id}")
	public ResponseEntity<APIResponse> disablePharmacyMedicineInventories(@PathVariable Integer id) {

		APIResponse apiResponse = new APIResponse();

		try {
			pharmacyMedicineService.disablePharmacyMedicineInventories(id);
			apiResponse.setStatus(200);
			apiResponse.setData("Medicine Inventorie disabled succesfully");

		} catch (Exception e) {
			apiResponse.setStatus(500);
			apiResponse.setError(e.getMessage());
		}
		return ResponseEntity.status(apiResponse.getStatus()).body(apiResponse);
	}

	@DeleteMapping("pharmacyPurchases/{id}")
	public ResponseEntity<APIResponse> disablePharmacyPurchases(@PathVariable Integer id) {

		APIResponse apiResponse = new APIResponse();

		try {
			pharmacyMedicineService.disablePharmacyPurchases(id);
			apiResponse.setStatus(200);
			apiResponse.setData("Pharmacy Purchases disabled succesfully");

		} catch (Exception e) {
			apiResponse.setStatus(500);
			apiResponse.setError(e.getMessage());
		}
		return ResponseEntity.status(apiResponse.getStatus()).body(apiResponse);
	}

	// get medical prescription by appointment id
	@GetMapping("medicineprescription/{appointmentid}")
	public List<MedicinePrescription> getMedicinePrescriptionByAppointmentId(@PathVariable Integer appointmentId) {
		return pharmacyMedicineService.getMedicinePrescriptionByAppointmentId(appointmentId);
	}

	// get medical prescription by id
	@GetMapping("medicineprescription/searchbyid/{id}")
	public List<MedicinePrescription> getMedicinePrescriptionById(@PathVariable Integer id) {
		return pharmacyMedicineService.getMedicinePrescriptionById(id);
	}

}
