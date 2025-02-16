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
import org.springframework.web.bind.annotation.RequestHeader;
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
import com.athira.demo.util.JwtUtils;

@RestController
@RequestMapping("api/")
public class PharmacyController {

	@Autowired
	IPharmacyMedicineService pharmacyMedicineService;
	
	@Autowired
	JwtUtils jwtUtils;

	@GetMapping("medicines")
	public List<PharmacyMedicine> getAllMedicines() {
		return pharmacyMedicineService.getAllMedicines();
	}

	@GetMapping("medicinesCategories")
	public List<PharmacyMedicineCategory> getAllPharmacyMedicineCategories() {

		return pharmacyMedicineService.getAllPharmacyMedicineCategories();
	}

	@GetMapping("medicineInventories")
	public ResponseEntity<APIResponse> getAllPharmacyMedicineInventories(
			@RequestHeader(value = "authorization", defaultValue = "") String auth) {
		
		APIResponse apiResponse = new APIResponse();
		ResponseEntity<APIResponse> tokenResponse = jwtUtils.verifyToken(auth);

		if (tokenResponse != null) {
			return tokenResponse;
		}
		
		try {
			List<PharmacyMedicineInventory> pharmacyMedicineEntity = pharmacyMedicineService.getAllPharmacyMedicineInventories();
			apiResponse.setStatus(200);
			apiResponse.setData(pharmacyMedicineEntity);

		} catch (Exception e) {
			apiResponse.setStatus(500);
			apiResponse.setError(e.getMessage());
		}
		return ResponseEntity.status(apiResponse.getStatus()).body(apiResponse);
 
	}

	@GetMapping("pharmacyPurchases")
	public ResponseEntity<APIResponse> getAllPharmacyPurchases(
			@RequestHeader(value = "authorization", defaultValue = "") String auth) {
		
		APIResponse apiResponse = new APIResponse();

		ResponseEntity<APIResponse> tokenResponse = jwtUtils.verifyToken(auth);

		if (tokenResponse != null) {
			return tokenResponse;
		}
		try {
			List<PharmacyPurchase> pharmacyMedicineInv = pharmacyMedicineService.getAllPharmacyPurchases();
			apiResponse.setStatus(200);
			apiResponse.setData(pharmacyMedicineInv);

		} catch (Exception e) {
			apiResponse.setStatus(500);
			apiResponse.setError(e.getMessage());
		}
		return ResponseEntity.status(apiResponse.getStatus()).body(apiResponse);
		 
	}

	// ADD new medicine
	@PostMapping("medicines")
	private ResponseEntity<APIResponse> addMedicines(@RequestBody PharmacyMedicine pharmacyMedicine,
			@RequestHeader(value = "authorization", defaultValue = "") String auth) {

		APIResponse apiResponse = new APIResponse();

		ResponseEntity<APIResponse> tokenResponse = jwtUtils.verifyToken(auth);

		if (tokenResponse != null) {
			return tokenResponse;
		}
		
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
			@RequestBody PharmacyMedicineInventory phMedicineInventory,
			@RequestHeader(value = "authorization", defaultValue = "") String auth) {

		APIResponse apiResponse = new APIResponse();

		ResponseEntity<APIResponse> tokenResponse = jwtUtils.verifyToken(auth);

		if (tokenResponse != null) {
			return tokenResponse;
		}
		
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
			@RequestBody PharmacyMedicineCategory phMedCategory,
			@RequestHeader(value = "authorization", defaultValue = "") String auth) {

		APIResponse apiResponse = new APIResponse();

		ResponseEntity<APIResponse> tokenResponse = jwtUtils.verifyToken(auth);

		if (tokenResponse != null) {
			return tokenResponse;
		}
		
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
	private ResponseEntity<APIResponse> updateMedicines(@RequestBody PharmacyMedicine pharmacyMedicine,
			@RequestHeader(value = "authorization", defaultValue = "") String auth) {

		APIResponse apiResponse = new APIResponse();

		ResponseEntity<APIResponse> tokenResponse = jwtUtils.verifyToken(auth);

		if (tokenResponse != null) {
			return tokenResponse;
		}
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
			@RequestBody PharmacyMedicineCategory phMedCategory,
			@RequestHeader(value = "authorization", defaultValue = "") String auth) {

		APIResponse apiResponse = new APIResponse();
		ResponseEntity<APIResponse> tokenResponse = jwtUtils.verifyToken(auth);

		if (tokenResponse != null) {
			return tokenResponse;
		}
		
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
			@RequestBody PharmacyMedicineInventory phMedicineInventory,
			@RequestHeader(value = "authorization", defaultValue = "") String auth) {

		APIResponse apiResponse = new APIResponse();
		ResponseEntity<APIResponse> tokenResponse = jwtUtils.verifyToken(auth);

		if (tokenResponse != null) {
			return tokenResponse;
		}
		
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
	public ResponseEntity<APIResponse> addPharmacyPurchases(@RequestBody PharmacyPurchase phPurchase,
			@RequestHeader(value = "authorization", defaultValue = "") String auth) {

		APIResponse apiResponse = new APIResponse();
		ResponseEntity<APIResponse> tokenResponse = jwtUtils.verifyToken(auth);

		if (tokenResponse != null) {
			return tokenResponse;
		}
		
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
	public ResponseEntity<APIResponse> updatePharmacyPurchases(@RequestBody PharmacyPurchase phPurchase,
			@RequestHeader(value = "authorization", defaultValue = "") String auth) {

		APIResponse apiResponse = new APIResponse();
		ResponseEntity<APIResponse> tokenResponse = jwtUtils.verifyToken(auth);

		if (tokenResponse != null) {
			return tokenResponse;
		}
		
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
	public ResponseEntity<APIResponse> disableMedicines(@PathVariable Integer id,
			@RequestHeader(value = "authorization", defaultValue = "") String auth) {

		APIResponse apiResponse = new APIResponse();
		ResponseEntity<APIResponse> tokenResponse = jwtUtils.verifyToken(auth);

		if (tokenResponse != null) {
			return tokenResponse;
		}
		
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
	public ResponseEntity<APIResponse> disablePharmacyMedicineCategories(@PathVariable Integer id,
			@RequestHeader(value = "authorization", defaultValue = "") String auth) {

		APIResponse apiResponse = new APIResponse();
		ResponseEntity<APIResponse> tokenResponse = jwtUtils.verifyToken(auth);

		if (tokenResponse != null) {
			return tokenResponse;
		}
		
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
	public ResponseEntity<APIResponse> disablePharmacyMedicineInventories(@PathVariable Integer id,
			@RequestHeader(value = "authorization", defaultValue = "") String auth) {

		APIResponse apiResponse = new APIResponse();
		ResponseEntity<APIResponse> tokenResponse = jwtUtils.verifyToken(auth);

		if (tokenResponse != null) {
			return tokenResponse;
		}
		
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
	public ResponseEntity<APIResponse> disablePharmacyPurchases(@PathVariable Integer id,
			@RequestHeader(value = "authorization", defaultValue = "") String auth) {

		APIResponse apiResponse = new APIResponse();
		ResponseEntity<APIResponse> tokenResponse = jwtUtils.verifyToken(auth);

		if (tokenResponse != null) {
			return tokenResponse;
		}
		
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
	public ResponseEntity<APIResponse> getMedicinePrescriptionByAppointmentId(@PathVariable Integer appointmentId,
			@RequestHeader(value = "authorization", defaultValue = "") String auth) {
		
		APIResponse apiResponse = new APIResponse();

		ResponseEntity<APIResponse> tokenResponse = jwtUtils.verifyToken(auth);

		if (tokenResponse != null) {
			return tokenResponse;
		}

		try {
			List<MedicinePrescription> prescriptions = pharmacyMedicineService.getMedicinePrescriptionByAppointmentId(appointmentId);
			apiResponse.setStatus(200);
			apiResponse.setData(prescriptions);

		} catch (Exception e) {
			apiResponse.setStatus(500);
			apiResponse.setError(e.getMessage());
		}
		return ResponseEntity.status(apiResponse.getStatus()).body(apiResponse);

	}

	// get medical prescription by id
	@GetMapping("medicineprescription/searchbyid/{id}")
	public ResponseEntity<APIResponse> getMedicinePrescriptionById(@PathVariable Integer id,
			@RequestHeader(value = "authorization", defaultValue = "") String auth) {
		
		APIResponse apiResponse = new APIResponse();

		ResponseEntity<APIResponse> tokenResponse = jwtUtils.verifyToken(auth);

		if (tokenResponse != null) {
			return tokenResponse;
		}

		try {
			List<MedicinePrescription> prescriptions = pharmacyMedicineService.getMedicinePrescriptionById(id);
			apiResponse.setStatus(200);
			apiResponse.setData(prescriptions);

		} catch (Exception e) {
			apiResponse.setStatus(500);
			apiResponse.setError(e.getMessage());
		}
		return ResponseEntity.status(apiResponse.getStatus()).body(apiResponse);
	}

}
