package com.OrderService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.InventoryService.InventoryService;
import com.PaymentService.PaymentService;

@Service
public class OrderService {

	@Autowired
	private PaymentService ps;
	
	@Autowired
	private InventoryService is;
	
	
	public void doOrder() throws InterruptedException {
		
		if(is.isInventory()) {
			
			ps.doPayment();
		}
	}
}
