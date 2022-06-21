package com.shipment.main.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.shipment.main.entity.Country;

@Repository
public interface CountryRepository extends JpaRepository<Country, Long> {

	@Query("SELECT c FROM Country c WHERE c.code = ?1")
	Country findByCode(String code);
}
