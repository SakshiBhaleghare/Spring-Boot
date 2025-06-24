package com.OtherServices;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class OtherServices {

	@Async("asynchTaskExecution")
	public void notificaton() throws InterruptedException {

		Thread.sleep(4000);
		System.out.println("Notificaton started");
	}

	@Async("asynchTaskExecution")
	public void Invoice() throws InterruptedException {

		Thread.sleep(4000);
		System.out.println("Invoice generated");
	}

	@Async("asynchTaskExecution")
	public void packaging() throws InterruptedException {

		Thread.sleep(4000);
		System.out.println("Packaging started");
	}

	@Async("asynchTaskExecution")
	public void shipping() throws InterruptedException {

		Thread.sleep(4000);
		System.out.println("Shipping started");
	}
}
