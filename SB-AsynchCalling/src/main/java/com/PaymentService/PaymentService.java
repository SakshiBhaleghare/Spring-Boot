package com.PaymentService;

import org.springframework.stereotype.Service;

@Service
public class PaymentService {

	public void doPayment() throws InterruptedException {
		
		System.out.println("Payment started");
		Thread.sleep(4000);
		System.out.println("Payment end");
	}
}
