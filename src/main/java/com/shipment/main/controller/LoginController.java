package com.shipment.main.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

	@GetMapping("/login")
	public String LongIn(Model model) {
		model.addAttribute("title","Shipment Login");
		return "LogIn.html";
	}
}
