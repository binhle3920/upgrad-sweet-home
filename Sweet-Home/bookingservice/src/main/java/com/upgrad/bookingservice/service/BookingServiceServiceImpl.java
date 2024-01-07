package com.upgrad.bookingservice.service;

import java.util.ArrayList;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.upgrad.bookingservice.dto.PaymentDTO;
import com.upgrad.bookingservice.entity.BookingInfoEntity;
import com.upgrad.bookingservice.repository.BookingServiceDAOImpl;

@Service
public class BookingServiceServiceImpl{

	@Autowired 
	private BookingServiceDAOImpl bookingdaoImpl;
	 
	public BookingInfoEntity bookRoom(BookingInfoEntity entity) {
		// TODO Auto-generated method stub
		return bookingdaoImpl.bookARoom(entity);
	}
	
	public static String getRandomNumbers(int count){                
        Random rand = new Random();                
        int upperBound = 100;                
        ArrayList<String>numberList = new ArrayList<String>();                

       for (int i=0; i<count; i++){                
                   numberList.add(String.valueOf(rand.nextInt(upperBound)));                
        }                
       String joined  = String.join(",", numberList);
       
       return joined;                
}
	
	public BookingInfoEntity completeTransaction(int bookingid,PaymentDTO request) {
		return bookingdaoImpl.completeTransaction(bookingid, request);
	}

}
