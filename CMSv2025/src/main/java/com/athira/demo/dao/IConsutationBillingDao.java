package com.athira.demo.dao;

import org.joda.time.DateTime;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Repository;

import com.athira.demo.entity.ConsultationBilling;

@Repository
public interface IConsutationBillingDao extends JpaRepository<ConsultationBilling , Integer> {

	@Procedure("spCreateConsultationBilling")
	ConsultationBilling spCreateConsultationBilling(Integer appointmentId, double additionalCostAny, double totalAmount,
			double amountPaid, double outstandingAmt, DateTime billingDate, String paymentStatus);

}
