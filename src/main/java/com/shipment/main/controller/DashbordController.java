package com.shipment.main.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DashbordController {

	@GetMapping("/")
	public String dashbordView() {
		return "Dashbord.html";
	}
}
