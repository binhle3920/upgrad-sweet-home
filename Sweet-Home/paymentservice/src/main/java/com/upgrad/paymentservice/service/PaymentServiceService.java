package com.upgrad.paymentservice.service;

import com.upgrad.paymentservice.entity.PaymentServiceEntity;

public interface PaymentServiceService {

	public int doTransaction(PaymentServiceEntity entity);
	
	public PaymentServiceEntity getTransactionDetailsBasedOnId(int id);
}
