package com.DTO;

import com.Entity.Store;

import lombok.Data;

@Data
public class StoreDTO {

	private String name;
	private String address;
	private double overallRating;
	private Integer userRating;
	public Object matches(String filter) {
		// TODO Auto-generated method stub
		return null;
	}

}
