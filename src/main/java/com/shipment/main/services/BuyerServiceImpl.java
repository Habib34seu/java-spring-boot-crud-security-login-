package com.shipment.main.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shipment.main.entity.Buyer;
import com.shipment.main.repository.BuyerRepository;

@Service
public class BuyerServiceImpl implements BuyerServices{

	@Autowired
	private BuyerRepository buyerRepository;
	@Override
	public List<Buyer> getAllBuyer() {
		
		return buyerRepository.findAll();
	}
	@Override
	public void saveBuyer(Buyer buyer) {
		this.buyerRepository.save(buyer);
		
	}
	@Override
	public Buyer getBuyerById(Long id) {
		
		Optional<Buyer> optional = buyerRepository.findById(id);
		Buyer buyer = null;
		if(optional.isPresent()) {
			buyer = optional.get();
		}else {
			throw new RuntimeException("Buyer Not Found");
		}
		return buyer;
	}
	@Override
	public void deleteBuyerById(Long id) {
		this.buyerRepository.deleteById(id);
		
	}

}
