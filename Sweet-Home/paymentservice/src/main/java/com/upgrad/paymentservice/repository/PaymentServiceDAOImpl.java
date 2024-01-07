package com.upgrad.paymentservice.repository;

import org.springframework.beans.factory.annotation.Autowired;

import com.upgrad.paymentservice.entity.PaymentServiceEntity;

public class PaymentServiceDAOImpl {
	
	@Autowired
	private PaymentServiceDAO paymentDao;
	
	public int doPayment(PaymentServiceEntity entity) {
		int transactionId = paymentDao.save(entity).getId();
		return transactionId;
	}
	
	public PaymentServiceEntity getPaymentDetails(int id) {
		PaymentServiceEntity entity = paymentDao.findById(id).get();
		return entity;
		
	}
}
