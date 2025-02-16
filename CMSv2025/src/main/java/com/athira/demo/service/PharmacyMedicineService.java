package com.athira.demo.service;

import java.util.List;

import javax.transaction.Transactional;

import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.athira.demo.dao.IMedicinePrescriptionDao;
import com.athira.demo.dao.IPharmacyMedicineCategoryDao;
import com.athira.demo.dao.IPharmacyMedicineDao;
import com.athira.demo.dao.IPharmacyMedicineInventoryDao;
import com.athira.demo.dao.IPharmacyPurchaseDao;
import com.athira.demo.entity.MedicinePrescription;
import com.athira.demo.entity.PharmacyMedicine;
import com.athira.demo.entity.PharmacyMedicineCategory;
import com.athira.demo.entity.PharmacyMedicineInventory;
import com.athira.demo.entity.PharmacyPurchase;

@Transactional
@Service
public class PharmacyMedicineService implements IPharmacyMedicineService {

	private static final Logger logger = LoggerFactory.getLogger(PharmacyMedicineService.class);

	@Autowired
	IPharmacyMedicineDao phMedicineDao;

	@Autowired
	IPharmacyMedicineCategoryDao phMedicineCategoryDao;

	@Autowired
	IPharmacyMedicineInventoryDao phMedicineInventoryDao;

	@Autowired
	IPharmacyPurchaseDao phPurchaseDao;

	@Autowired
	IMedicinePrescriptionDao medicinePrescriptionDao;

	public List<PharmacyMedicine> getAllMedicines() {
		return phMedicineDao.findAll();
	}

	@Transactional
	public List<PharmacyMedicineCategory> getAllPharmacyMedicineCategories() {
		return phMedicineCategoryDao.findAll();
	}

	@Transactional
	public List<PharmacyMedicineInventory> getAllPharmacyMedicineInventories() {
		return phMedicineInventoryDao.findAll();
	}

	@Transactional
	public List<PharmacyPurchase> getAllPharmacyPurchases() {
		return phPurchaseDao.findAll();
	}

	public PharmacyMedicineInventory addToMedicinesInventory(PharmacyMedicineInventory phMedInventory) {

		if (phMedInventory.isActive() == null) {
			phMedInventory.setActive(true);
		}
		if (phMedInventory.getCreatedDate() == null) {
			phMedInventory.setCreatedDate(new DateTime());
		}
		return phMedicineInventoryDao.spAddMedicineInventory(phMedInventory.getpMed(), phMedInventory.getCreatedDate(),
				phMedInventory.getExpiryDate(), phMedInventory.getManufacturer(), phMedInventory.getCount(),
				phMedInventory.getLowFlag(), phMedInventory.isActive());
	}

	public PharmacyMedicine addMedicines(PharmacyMedicine phMedicine) {

		if (phMedicine.isActive() == null) {
			phMedicine.setActive(true);
		}
		if (phMedicine.getCreatedDate() == null) {
			phMedicine.setCreatedDate(new DateTime());
		}

		try {
			return phMedicineDao.spAddNewMedicine(phMedicine.getpMedCatId(), phMedicine.getName(),
					phMedicine.getDetails(), phMedicine.getCreatedDate(), phMedicine.isActive());
		} catch (IllegalArgumentException e) {
			logger.error("Invalid input for Pharmacy Medicine: {}", e.getMessage());
			throw new IllegalArgumentException("Invalid input!", e);
		} catch (DataAccessException e) {
			logger.error("Data access error while adding Pharmacy Medicine : {}", e.getMessage());
			throw new IllegalArgumentException("Data access exception occured while adding new Pharmacy Medicine ");
		} catch (Exception e) {
			logger.error("Unexpected error while adding Pharmacy Medicine: {}", e.getMessage());
			throw new IllegalArgumentException("Unexpected exception occured while updating Pharmacy Medicine ");
		}
	}

	public PharmacyMedicineCategory addPharmacyMedicineCategory(PharmacyMedicineCategory phMedCategory) {

		if (phMedCategory.isActive() == null) {
			phMedCategory.setActive(true);
		}
		if (phMedCategory.getCreatedDate() == null) {
			phMedCategory.setCreatedDate(new DateTime());
		}

		try {
			return phMedicineCategoryDao.spAddNewMedicineCategory(phMedCategory.getpMedCatName(),
					phMedCategory.getDetails(), phMedCategory.getCreatedDate(), phMedCategory.isActive());
		} catch (IllegalArgumentException e) {
			logger.error("Invalid input for Pharmacy Medicine category: {}", e.getMessage());
			throw new IllegalArgumentException("Invalid input!", e);
		} catch (DataAccessException e) {
			logger.error("Data access error while adding Pharmacy Medicine category: {}", e.getMessage());
			throw new IllegalArgumentException(
					"Data access exception occured while adding new Pharmacy Medicine category");
		} catch (Exception e) {
			logger.error("Unexpected error while adding Pharmacy Medicine category: {}", e.getMessage());
			throw new IllegalArgumentException(
					"Unexpected exception occured while updating Pharmacy Medicine category");
		}
	}

	public PharmacyMedicine updateMedicines(PharmacyMedicine phMedicine) {

		try {

			return phMedicineCategoryDao.spUpdateMedicine(phMedicine.getName(), phMedicine.getDetails(),
					phMedicine.getpMedCatId(), phMedicine.getpMedId(), phMedicine.getCreatedDate(),
					phMedicine.isActive());

		} catch (IllegalArgumentException e) {
			logger.error("Invalid input for Pharmacy Medicine: {}", e.getMessage());
			throw new IllegalArgumentException("Invalid input!", e);
		} catch (DataAccessException e) {
			logger.error("Data access error while updating Pharmacy Medicine: {}", e.getMessage());
			throw new IllegalArgumentException("Data access exception occured while updating new Pharmacy Medicine");
		} catch (Exception e) {
			logger.error("Unexpected error while updating Pharmacy Medicine: {}", e.getMessage());
			throw new IllegalArgumentException("Unexpected exception occured while updating Pharmacy ");
		}
	}

	public PharmacyMedicineCategory updatePharmacyMedicineCategory(PharmacyMedicineCategory phMedCategory) {
		try {

			return phMedicineCategoryDao.spUpdateMedicineCategory(phMedCategory.getpMedCatName(),
					phMedCategory.getDetails(), phMedCategory.getpMedCatId(), phMedCategory.getCreatedDate(),
					phMedCategory.isActive());

		} catch (IllegalArgumentException e) {
			logger.error("Invalid input for Pharmacy Medicine category: {}", e.getMessage());
			throw new IllegalArgumentException("Invalid input!", e);
		} catch (DataAccessException e) {
			logger.error("Data access error while updating Pharmacy Medicine category: {}", e.getMessage());
			throw new IllegalArgumentException(
					"Data access exception occured while updating new Pharmacy Medicine category");
		} catch (Exception e) {
			logger.error("Unexpected error while adding updating Medicine category: {}", e.getMessage());
			throw new IllegalArgumentException(
					"Unexpected exception occured while updating Pharmacy Medicine category");
		}

	}

	public PharmacyMedicineInventory updateMedicinesInventory(PharmacyMedicineInventory phMedInventory) {
		try {

			return phMedicineInventoryDao.spUpdateMedInventory(phMedInventory.getpMedInvId(), phMedInventory.getpMedId(),
					phMedInventory.getExpiryDate(), phMedInventory.getManufacturer(), phMedInventory.getCount(),
					phMedInventory.getLowFlag(), phMedInventory.getCreatedDate(), phMedInventory.isActive());

		} catch (IllegalArgumentException e) {
			logger.error("Invalid input for Pharmacy Medicine inventory: {}", e.getMessage());
			throw new IllegalArgumentException("Invalid input!", e);
		} catch (DataAccessException e) {
			logger.error("Data access error while updating Pharmacy Medicine inventory: {}", e.getMessage());
			throw new IllegalArgumentException(
					"Data access exception occured while updating new Pharmacy Medicine inventory");
		} catch (Exception e) {
			logger.error("Unexpected error while adding updating Medicine inventory: {}", e.getMessage());
			throw new IllegalArgumentException(
					"Unexpected exception occured while updating Pharmacy Medicine inventory");
		}
	
	}

	public PharmacyPurchase savePharmacyPurchases(PharmacyPurchase phPurchase) {
		return phPurchaseDao.save(phPurchase);
	}

	public void disableMedicines(Integer id) {
		phMedicineDao.disableMedicines(id);
	}

	public void disablePharmacyMedicineCategories(Integer id) {
		phMedicineCategoryDao.disablePharmacyMedicineCategories(id);
	}

	public void disablePharmacyMedicineInventories(Integer id) {
		phMedicineInventoryDao.disablePharmacyMedicineInventories(id);
	}

	public void disablePharmacyPurchases(Integer id) {
		phPurchaseDao.disablePharmacyPurchases(id);
	}

	public List<MedicinePrescription> getMedicinePrescriptionByAppointmentId(Integer appointmentId) {
		return medicinePrescriptionDao.spGetMedicalPrescriptionByAppointmentId(appointmentId);
	}

	public List<MedicinePrescription> getMedicinePrescriptionById(Integer id) {
		return medicinePrescriptionDao.spGetMedPrescriptionForAPatient(id);
	}
}