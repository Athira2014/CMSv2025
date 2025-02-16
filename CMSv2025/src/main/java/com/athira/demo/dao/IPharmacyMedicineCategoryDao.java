package com.athira.demo.dao;

import org.joda.time.DateTime;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.athira.demo.entity.PharmacyMedicine;
import com.athira.demo.entity.PharmacyMedicineCategory;

@Repository
public interface IPharmacyMedicineCategoryDao extends JpaRepository<PharmacyMedicineCategory, Integer> {

	@Procedure("spAddNewMedicineCategory")
	PharmacyMedicineCategory spAddNewMedicineCategory(String getpMedCatName, String details, DateTime createdDate,
			Boolean active);

	@Procedure("spUpdateMedicine")
	PharmacyMedicine spUpdateMedicine(String name, String details, Integer getpMedCatId, Integer getpMedId,
			DateTime createdDate, Boolean active);

	@Procedure("spUpdateMedicineCategory")
	PharmacyMedicineCategory spUpdateMedicineCategory(String getpMedCatName, String details, int getpMedCatId,
			DateTime createdDate, Boolean active);

	@Modifying
	@Query("UPDATE com.athira.demo.entity.PharmacyMedicineCategory SET isActive = 0 WHERE pMedCatId = :id")
	void disablePharmacyMedicineCategories(@Param("id")Integer id);

}
