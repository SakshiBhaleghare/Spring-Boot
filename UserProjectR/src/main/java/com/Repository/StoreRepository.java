package com.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Entity.Store;

@Repository
public interface StoreRepository extends JpaRepository<Store, Long> {

	List<Store> findByNameContainingIgnoreCaseOrAddressContainingIgnoreCase(String name, String address);

}
