package com.shipment.main.countryTest;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import com.shipment.main.entity.Country;
import com.shipment.main.repository.CountryRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class CountryApplicationRepositoryTest {

	@Autowired
	private CountryRepository countryRepository;

	@Autowired
	private TestEntityManager testEntityManager;

	@Test
	public void testCreateCountry() {
		Country country = new Country();
		country.setCode("BD");
		country.setName("Bangladesh");

		Country saveCountry = countryRepository.save(country);
		Country existCountry = testEntityManager.find(Country.class, saveCountry.getId());

		assertThat(existCountry.getCode()).isEqualTo(country.getCode());
	}
	
	
	@Test
	public void testFindByCountryCode() {
		String code = "BD";
		Country country = countryRepository.findByCode(code);
		assertThat(country).isNotNull();
	}

}
