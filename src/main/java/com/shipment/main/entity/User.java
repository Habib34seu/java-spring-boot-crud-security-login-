package com.shipment.main.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "user")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	@Column(name = "user_id", unique = true, nullable = false, columnDefinition = "TEXT")
	private String userId;
	@Column(name = "user_name", nullable = false, columnDefinition = "TEXT")
	private String name;
	@Column(name = "user_password", nullable = false, columnDefinition = "Text")
	private String password;

}
