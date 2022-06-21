package com.shipment.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.shipment.main.entity.Country;
import com.shipment.main.services.CountryServices;

@Controller
public class CountryController {

	@Autowired
	CountryServices countryServices;

	@GetMapping("/country")
	public String GetAllCountry(Model model) {
		model.addAttribute("title", "Country Information");
		model.addAttribute("countryList", countryServices.getAllCountry());
		return "AllCountry.html";
	}

	@GetMapping("/country/add")
	public String showCountryForm(Model model) {
		model.addAttribute("title", "Add New Country");

		Country country = new Country();
		model.addAttribute("country", country);
		return "AddNewCountry.html";
	}

	@PostMapping("/country/save")
	public String saveCountry(@ModelAttribute("country") Country country) {
		countryServices.saveCountry(country);
		
		return "redirect:/country";
	}
	
	@GetMapping("/country/update/{id}")
	public String showCountryUpdateForm(@PathVariable(value="id") Long id, Model model) {
		model.addAttribute("title","Update Country");
		Country country = countryServices.getCountryById(id);
		model.addAttribute("country",country);
		return  "UpdateCountry.html";
	}
	
	@GetMapping("/country/delete/{id}")
	public String deleteCountry(@PathVariable(value="id") Long id) {
		this.countryServices.deleteCountryById(id);
		return "redirect:/country";
	}
	

}
