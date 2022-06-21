package com.shipment.main.services;

import java.util.List;

import com.shipment.main.entity.User;

public interface UserServices {

	List<User> getAllUsers();
	void saveUser(User user);
}
