package com.upgrad.paymentservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.upgrad.paymentservice.entity.PaymentServiceEntity;
import com.upgrad.paymentservice.repository.PaymentServiceDAOImpl;

@Service
public class PaymentServiceServiceImpl implements PaymentServiceService{

	@Autowired
	private PaymentServiceDAOImpl paymentDaoImpl;
	
	@Override
	public int doTransaction(PaymentServiceEntity entity) {
		return paymentDaoImpl.doPayment(entity);
	}

	@Override
	public PaymentServiceEntity getTransactionDetailsBasedOnId(int id) {
		// TODO Auto-generated method stub
		return paymentDaoImpl.getPaymentDetails(id);
	}

}
