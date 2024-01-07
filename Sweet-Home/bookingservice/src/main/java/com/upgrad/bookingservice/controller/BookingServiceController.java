package com.upgrad.bookingservice.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.upgrad.bookingservice.dto.BookingDTO;
import com.upgrad.bookingservice.dto.PaymentDTO;
import com.upgrad.bookingservice.entity.BookingInfoEntity;
import com.upgrad.bookingservice.service.BookingServiceServiceImpl;

@RestController
public class BookingServiceController {
	
	@Autowired
	private BookingServiceServiceImpl bookingService;
	
	@PostMapping("/booking")
	public ResponseEntity<BookingInfoEntity> bookARoom(@RequestBody BookingDTO request) {
		BookingInfoEntity bookedRoom = new BookingInfoEntity();
		try {
			BookingInfoEntity entity = new BookingInfoEntity(); 
			Date fromDate = new SimpleDateFormat("yyyy-MM-dd").parse(request.getFromDate());
			Date toDate = new SimpleDateFormat("yyyy-MM-dd").parse(request.getToDate());
			entity.setFromDate(fromDate);
			entity.setToDate(toDate);
			entity.setAadharNumber(request.getAadharNumber());
			entity.setNumOfRooms(Integer.valueOf(request.getNumOfRooms()));
			
			LocalDateTime myDateObj = LocalDateTime.now();  
		    DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("yyyy-MM-dd");  
		    String formattedDate = myDateObj.format(myFormatObj); 
		    Date bookedDate = new SimpleDateFormat("yyyy-MM-dd").parse(formattedDate);
			entity.setBookedOn(bookedDate);
			
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
		    Date firstDate = sdf.parse(request.getFromDate());
		    Date secondDate = sdf.parse(request.getToDate());
		    long diffInMillies = Math.abs(secondDate.getTime() - firstDate.getTime());
		    long diff = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);
			entity.setRoomPrice((int) (1000*diff*Integer.valueOf(request.getNumOfRooms())));
			
			String roomNumbers = bookingService.getRandomNumbers(Integer.valueOf(request.getNumOfRooms()));
			entity.setRoomNumbers(roomNumbers);
			
			bookedRoom = bookingService.bookRoom(entity);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
		return new ResponseEntity<BookingInfoEntity>(bookedRoom,HttpStatusCode.valueOf(201));
	}
	
	@PostMapping("booking/{bookingId}/transaction")
	public ResponseEntity<BookingInfoEntity> completeTransaction(@PathVariable int bookingId, @RequestBody PaymentDTO paymentRequest){
	    String paymentMode = paymentRequest.getPaymentMode();
        String upiId = paymentRequest.getUpiId();
        String cardNumber = paymentRequest.getCardNumber();
		int bookingid = bookingId;
		BookingInfoEntity entity = bookingService.completeTransaction(bookingid, paymentRequest);
		return new ResponseEntity<BookingInfoEntity>(entity,HttpStatusCode.valueOf(201));
	}

}
