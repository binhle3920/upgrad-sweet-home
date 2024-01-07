package com.upgrad.paymentservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.upgrad.paymentservice.entity.PaymentServiceEntity;
import com.upgrad.paymentservice.service.PaymentServiceService;
import com.upgrad.paymentservice.service.PaymentServiceServiceImpl;

@RestController
@RequestMapping("/payment")
public class PaymentServiceController {
	
	@Autowired
	private PaymentServiceServiceImpl service;
	
	@PostMapping("/transaction")
	public int bookARoomTransaction(@RequestBody PaymentServiceEntity payment) {
		int transactionId = service.doTransaction(payment);
		return transactionId;
		
	}
	
	@PostMapping(" /transaction/{transactionId}")
    public ResponseEntity<PaymentServiceEntity> getTransactionDetails(@PathVariable int transactionId){
		PaymentServiceEntity entity = service.getTransactionDetailsBasedOnId(transactionId);
		return new ResponseEntity<PaymentServiceEntity>(entity,HttpStatusCode.valueOf(200));
		
	}

}
