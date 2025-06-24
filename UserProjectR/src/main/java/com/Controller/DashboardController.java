package com.Controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Service.StoreService;

@RestController
@RequestMapping("/api/owner")
public class DashboardController {

	@Autowired
	private StoreService storeService;

	@GetMapping("/dashboard")
	public ResponseEntity<?> getDashboard(Principal principal) {
		return ResponseEntity.ok(storeService.getOwnerDashboard(principal.getName()));
	}
}
