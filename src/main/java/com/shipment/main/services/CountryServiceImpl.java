package com.shipment.main.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shipment.main.entity.Country;
import com.shipment.main.repository.CountryRepository;

@Service
public class CountryServiceImpl implements CountryServices {

	@Autowired
	private CountryRepository countryRepository;
	@Override
	public List<Country> getAllCountry() {
		
		return countryRepository.findAll() ;
	}
	@Override
	public void saveCountry(Country country ) {
		this.countryRepository.save(country);
		
	}
	@Override
	public Country getCountryById(Long id) {
		Optional<Country> optional = countryRepository.findById(id);
		Country country = null;
		if(optional.isPresent()) {
			country = optional.get();
		}else {
			throw new RuntimeException("Country Not Found");
		}
		return country;
	}
	@Override
	public void deleteCountryById(Long id) {
		this.countryRepository.deleteById(id);
		
	}

}
