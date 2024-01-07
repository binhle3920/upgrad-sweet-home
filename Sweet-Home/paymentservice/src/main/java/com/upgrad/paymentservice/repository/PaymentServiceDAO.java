package com.upgrad.paymentservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.upgrad.paymentservice.entity.PaymentServiceEntity;

@Repository
public interface PaymentServiceDAO extends JpaRepository<PaymentServiceEntity, Integer>{

}
