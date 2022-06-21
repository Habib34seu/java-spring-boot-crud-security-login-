package com.shipment.main.services;

import java.util.List;

import com.shipment.main.entity.Buyer;

public interface BuyerServices {
	
	List<Buyer> getAllBuyer();
	void saveBuyer(Buyer buyer);
	Buyer getBuyerById(Long id);
	void deleteBuyerById(Long id);

}
