package com.shipment.main.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.shipment.main.enums.BuyerType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity(name = "buyer_info")
public class Buyer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "buyer_id")
	private Long id;
	@Column(name = "buyer_name", nullable = false, unique = true, columnDefinition = "TEXT", length = 128)
	private String name;
	@Column(name = "address", columnDefinition = "TEXT", nullable = false, length = 256)
	private String address;
	@Column(name = "area", columnDefinition = "TEXT", length = 128)
	private String area;
	@Column(name = "city", columnDefinition = "TEXT", length = 128)
	private String city;
	@Column(name = "state", columnDefinition = "TEXT", length = 128)
	private String state;
	@Column(name = "phone", columnDefinition = "TEXT", length = 128)
	private String phone;
	@Column(name = "fax", columnDefinition = "TEXT", length = 128)
	private String fax;
	@Column(name = "email", columnDefinition = "TEXT", nullable = false, length = 128)
	private String email;
	@Column(name = "web", columnDefinition = "TEXT", length = 256)
	private String web;
	@Column(name = "zip_code", columnDefinition = "TEXT", length = 128)
	private String zip_code;

	@Column(name ="buyer_type", nullable = false, columnDefinition = "TEXT", length = 10)
	private BuyerType buyerType;
	@ManyToOne
	@JoinColumn(name = "country_id")
	private Country country;
}
