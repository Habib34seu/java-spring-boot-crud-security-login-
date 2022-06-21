package com.shipment.main.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity(name="Country")
public class Country {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="country_id")
	private Long id;
	
	@Column(name="country_code", nullable = false, unique = true, columnDefinition = "TEXT")
	private String code;
	
	@Column(name="country_name", nullable = false, unique = true, columnDefinition = "TEXT")
	private String name;
	
	
}
