package com.InventoryService;

import org.springframework.stereotype.Service;

@Service
public class InventoryService {

	public boolean isInventory() {

		System.out.println("Inventory checking");

		return true;

	}
}
