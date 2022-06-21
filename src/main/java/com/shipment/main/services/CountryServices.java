package com.shipment.main.services;

import java.util.List;

import com.shipment.main.entity.Country;

public interface CountryServices {
	
	List<Country> getAllCountry();
	void saveCountry(Country Country);
    Country getCountryById(Long id);
    void deleteCountryById(Long id);
	
}
