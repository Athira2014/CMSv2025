package com.athira.demo.dao;

import org.joda.time.DateTime;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.athira.demo.entity.PharmacyMedicine;
import com.athira.demo.entity.PharmacyMedicineInventory;

@Repository
public interface IPharmacyMedicineInventoryDao extends JpaRepository<PharmacyMedicineInventory, Integer> {

	@Procedure("spAddMedicineInventory")
	PharmacyMedicineInventory spAddMedicineInventory(PharmacyMedicine getpMed, DateTime createdDate,
			DateTime expiryDate, String manufacturer, int count, char lowFlag, boolean active);

	@Procedure("spUpdateMedInventory")
	PharmacyMedicineInventory spUpdateMedInventory(Integer getpMedInvId, Integer getpMedId, DateTime expiryDate,
			String manufacturer, int count, char lowFlag, DateTime createdDate, Boolean active);

	@Modifying
	@Query("UPDATE com.athira.demo.entity.PharmacyMedicineInventory SET isActive = 0 WHERE pMedInvId = :id")
	void disablePharmacyMedicineInventories(@Param("id")Integer id);

}
