package com.athira.demo.dao;

import org.joda.time.DateTime;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.athira.demo.entity.PharmacyMedicine;

@Repository
public interface IPharmacyMedicineDao extends JpaRepository<PharmacyMedicine, Integer>{

	@Procedure("spAddNewMedicine")
	PharmacyMedicine spAddNewMedicine(Integer getpMedCatId, String name, String details, DateTime createdDate,
			Boolean active);

	@Modifying
	@Query("UPDATE com.athira.demo.entity.PharmacyMedicine SET isActive = 0 WHERE pMedId = :id")
	void disableMedicines(@Param("id")Integer id);
}
