package com.athira.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table; 
import org.hibernate.annotations.Type;
import org.joda.time.DateTime;

@Entity
@Table(name = "consulationbilling")
public class ConsultationBilling {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ConsultationBilltId")
    private Integer  consultationBilltId;

    @Column(name = "AdditionalCostAny", precision = 5, scale = 2)
    private double additionalCostAny;

    @Column(name = "TotalAmount", precision = 7, scale = 2)
    private double totalAmount;

    @Column(name = "AmountPaid", precision = 7, scale = 2)
    private double amountPaid;

    @Column(name = "OutstandingAmt", precision = 7, scale = 2)
    private double outstandingAmt;

    @Column(name = "BillingDate", nullable = false)
    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    private DateTime billingDate;

    @Column(name = "PAymentStatus", length = 20)
    private String paymentStatus;

    @ManyToOne
    @JoinColumn(name = "AppointmentId", insertable = false, updatable = false)
    private Appointment appointment; 
    
    @Column(name = "AppointmentId", nullable = false)
    private Integer  appointmentId;

    public ConsultationBilling() {}

	public ConsultationBilling(Integer consultationBilltId, double additionalCostAny, double totalAmount, double amountPaid,
			double outstandingAmt, DateTime billingDate, String paymentStatus, Appointment appointment) {
		super();
		this.consultationBilltId = consultationBilltId;
		this.additionalCostAny = additionalCostAny;
		this.totalAmount = totalAmount;
		this.amountPaid = amountPaid;
		this.outstandingAmt = outstandingAmt;
		this.billingDate = billingDate;
		this.paymentStatus = paymentStatus;
		this.appointment = appointment;
	}

	public Integer  getConsultationBilltId() {
		return consultationBilltId;
	}

	public void setConsultationBilltId(Integer consultationBilltId) {
		this.consultationBilltId = consultationBilltId;
	}

	public double getAdditionalCostAny() {
		return additionalCostAny;
	}

	public void setAdditionalCostAny(double additionalCostAny) {
		this.additionalCostAny = additionalCostAny;
	}

	public double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public double getAmountPaid() {
		return amountPaid;
	}

	public void setAmountPaid(double amountPaid) {
		this.amountPaid = amountPaid;
	}

	public double getOutstandingAmt() {
		return outstandingAmt;
	}

	public void setOutstandingAmt(double outstandingAmt) {
		this.outstandingAmt = outstandingAmt;
	}

	public DateTime getBillingDate() {
		return billingDate;
	}

	public void setBillingDate(DateTime billingDate) {
		this.billingDate = billingDate;
	}

	public String getPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
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

}
