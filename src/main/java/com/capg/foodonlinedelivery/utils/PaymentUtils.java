package com.capg.foodonlinedelivery.utils;
import java.util.ArrayList;
import java.util.List;

import com.capg.foodonlinedelivery.entities.Payment;
import com.capg.foodonlinedelivery.model.PaymentDTO;

public class PaymentUtils {

	public static List<PaymentDTO> convertToPaymentDtoList(List<Payment> list){
		List<PaymentDTO> dtolist = new ArrayList<PaymentDTO>();
		for(Payment Payment : list) 
			dtolist.add(convertToPaymentDto(Payment));
		return dtolist;
	}
	
	public static Payment convertToPayment(PaymentDTO Paymentdto) {
		Payment Payment = new Payment();
		Payment.setPaymentId(Paymentdto.getPaymentId());
		Payment.setPaymentDate(Paymentdto.getPaymentDate());
		Payment.setTotalItem(Paymentdto.getTotalItem());
		Payment.setTotalCost(Paymentdto.getTotalCost());
		Payment.setOrder(Paymentdto.getOrder());
		return Payment;
	}
	
	
		public static PaymentDTO convertToPaymentDto(Payment Payment) {
			PaymentDTO Paymentdto = new PaymentDTO();
			Paymentdto.setPaymentId(Payment.getPaymentId());
			Paymentdto.setPaymentDate(Payment.getPaymentDate());
			Paymentdto.setTotalItem(Payment.getTotalItem());
			Paymentdto.setTotalCost(Payment.getTotalCost());
			Paymentdto.setOrder(Payment.getOrder());
			
			return Paymentdto;
		}
		
}
//
