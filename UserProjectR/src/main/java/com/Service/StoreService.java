package com.Service;

import java.util.List;

import com.DTO.StoreDTO;
import com.Entity.Store;

public interface StoreService {

	void addStore(Store store);

	List<StoreDTO> getAllStores();

	List<StoreDTO> searchStores(String query);

	Object getOwnerDashboard(String name);
}
