package com.athira.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.athira.demo.entity.PharmacyPurchase;

@Repository
public interface IPharmacyPurchaseDao extends JpaRepository<PharmacyPurchase, Integer> {

	@Modifying
	@Query("UPDATE com.athira.demo.entity.PharmacyPurchase SET isActive = 0 WHERE pPurchaseId = :id")
	void disablePharmacyPurchases(@Param("id")Integer id);

}
