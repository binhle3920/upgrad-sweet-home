package com.upgrad.bookingservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.upgrad.bookingservice.entity.BookingInfoEntity;

@Repository
public interface BookingServiceDAO extends JpaRepository<BookingInfoEntity , Integer>{

}
