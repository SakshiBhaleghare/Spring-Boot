package com.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.DTO.StoreDTO;
import com.Service.StoreService;

@RestController
@RequestMapping("/api/stores")
public class StoreController {

	@Autowired
	private StoreService storeService;

	@GetMapping
	public List<StoreDTO> getAllStores() {
		return storeService.getAllStores();
	}

	@GetMapping("/search")
	public List<StoreDTO> searchStores(@RequestParam String query) {
		return storeService.searchStores(query);
	}
}
