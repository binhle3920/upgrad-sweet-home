package com.upgrad.bookingservice.repository;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

import com.upgrad.bookingservice.dto.PaymentDTO;
import com.upgrad.bookingservice.entity.BookingInfoEntity;
import com.upgrad.bookingservice.entity.PaymentServiceEntity;


public class BookingServiceDAOImpl {

	@Autowired
	private BookingServiceDAO bookingdao;
	
	@Autowired
	private RestTemplate restTemplate;

    public BookingInfoEntity bookARoom(BookingInfoEntity request) {
        return bookingdao.save(request);
    }
    
    public BookingInfoEntity completeTransaction(int bookingId,PaymentDTO request) {
    	Optional<BookingInfoEntity> entity = bookingdao.findById(bookingId);
    	if(!entity.isPresent())
    		return null;
    	Map<String,String> paymentMap = new HashMap<>();
    	paymentMap.put("paymentMode", request.getPaymentMode());
    	paymentMap.put("bookingId", String.valueOf(bookingId));
    	paymentMap.put("upiId", request.getUpiId());
    	paymentMap.put("cardNumber", request.getCardNumber());
    	
    	String url = "http://host.docker.internal:8083/payment/transaction";
    	
    	URI paymentEntity =  restTemplate.postForLocation(url, paymentMap);
    	if(paymentEntity==null)
    		return null;
    	
    	//entity.get().setTransactionId(paymentEntity.getId());
    	BookingInfoEntity finalEntity = bookingdao.save(entity.get());
    	return finalEntity;
    }
}
