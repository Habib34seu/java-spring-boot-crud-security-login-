package com.shipment.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.shipment.main.entity.User;
import com.shipment.main.services.UserServices;

@Controller
public class UserController {

	@Autowired
	private UserServices userServices;
	@GetMapping("/user")
	public String allUserInfo(Model model) {
		model.addAttribute("title","User");
		List<User> allUser = userServices.getAllUsers();
		model.addAttribute("userList",allUser);
		return "AllUserInformation.html";
	}
	@GetMapping("/adduserView")
	public String AddNewCountryShowFrom(Model model) {
		model.addAttribute("title","Add New User");
		User user = new User();
		model.addAttribute("user",user);
		return "AddNewUser.html";
	}
	@PostMapping("/saveUser")
	public String saveUser(@ModelAttribute("user") User user) {
		BCryptPasswordEncoder encoder =new BCryptPasswordEncoder();
		String encodePassword = encoder.encode(user.getPassword());
		user.setPassword(encodePassword);
		userServices.saveUser(user);
		return  "redirect:/user";
	}
}
